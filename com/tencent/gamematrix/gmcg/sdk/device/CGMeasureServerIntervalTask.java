package com.tencent.gamematrix.gmcg.sdk.device;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGMeasureServerIntervalTask extends AsyncTask<Void, Integer, Integer> {
    private long mEndTimeStamp;
    private int mIndex;
    private String mReqTag;
    private CalcServerReqIntervalListener mResultListener;
    private String mServerAddr;
    private long mStartTimestamp;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface CalcServerReqIntervalListener {
        void onServerReqIntervalGot(String str, int i3, String str2, int i16, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CGMeasureServerIntervalTask(String str, String str2, int i3, CalcServerReqIntervalListener calcServerReqIntervalListener) {
        this.mReqTag = str;
        this.mServerAddr = str2;
        this.mIndex = i3;
        this.mResultListener = calcServerReqIntervalListener;
    }

    private void endTimer() {
        this.mEndTimeStamp = System.currentTimeMillis();
    }

    private void endTimerWithError() {
        this.mEndTimeStamp = -1L;
    }

    private int getTimerInterval() {
        long j3 = this.mEndTimeStamp;
        if (j3 < 0) {
            return Integer.MAX_VALUE;
        }
        return (int) (j3 - this.mStartTimestamp);
    }

    private void startTimer() {
        this.mStartTimestamp = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        String[] split = this.mServerAddr.split(":");
        boolean z16 = false;
        String str = split[0];
        int parseInt = Integer.parseInt(split[1]);
        try {
            InetAddress byName = InetAddress.getByName(str);
            DatagramSocket datagramSocket = new DatagramSocket();
            String str2 = "ping" + this.mIndex;
            byte[] bytes = str2.getBytes("UTF8");
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, byName, parseInt);
            startTimer();
            datagramSocket.setSoTimeout(2000);
            datagramSocket.send(datagramPacket);
            datagramSocket.connect(byName, parseInt);
            DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
            datagramSocket.receive(datagramPacket2);
            datagramSocket.close();
            if (datagramPacket2.getData() != null && new String(datagramPacket2.getData(), 0, 10).startsWith(str2)) {
                z16 = true;
            }
            if (z16) {
                endTimer();
            } else {
                endTimerWithError();
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            endTimerWithError();
        }
        return Integer.valueOf(getTimerInterval());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        CalcServerReqIntervalListener calcServerReqIntervalListener = this.mResultListener;
        if (calcServerReqIntervalListener != null) {
            calcServerReqIntervalListener.onServerReqIntervalGot(this.mReqTag, num.intValue(), this.mServerAddr, this.mIndex, true);
        }
    }
}
