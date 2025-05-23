package com.tencent.qqmini.sdk.launcher.action;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EngineChannel implements Parcelable {
    public static final Parcelable.Creator<EngineChannel> CREATOR = new Parcelable.Creator<EngineChannel>() { // from class: com.tencent.qqmini.sdk.launcher.action.EngineChannel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EngineChannel createFromParcel(Parcel parcel) {
            EngineChannel engineChannel = new EngineChannel((ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel));
            engineChannel.setName(parcel.readString());
            return engineChannel;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EngineChannel[] newArray(int i3) {
            return new EngineChannel[i3];
        }
    };
    public static final String KEY_BUNDLE_BASE_LIBTYPE = "baseLibType";
    public static final String KEY_BUNDLE_ENGINE_CHANNEL = "engineChannel";
    public static final String KEY_BUNDLE_ENGINE_INSTALLER_MESSAGE = "engineInstallerMessage";
    public static final String KEY_BUNDLE_ENGINE_INSTALLER_PROGRESS = "engineInstallerProgress";
    public static final String KEY_BUNDLE_ENGINE_PID = "enginePid";
    public static final String KEY_BUNDLE_INSTALLED_ENGINE_LIST = "installedEngineList";
    public static final String KEY_BUNDLE_INVALID_ENGINE = "invalidEngine";
    public static final String LOG_TAG = "EngineChannel";
    public static final int WHAT_EVENT_ACK = 55;
    public static final int WHAT_EVENT_BASE = 50;
    public static final int WHAT_EVENT_DELETE_INVALID_ENGINE = 56;
    public static final int WHAT_EVENT_INSTALLED_ENGINE_LIST = 51;
    public static final int WHAT_EVENT_INSTALL_LATEST_ENGINE_BEGIN = 52;
    public static final int WHAT_EVENT_INSTALL_LATEST_ENGINE_FINISH = 54;
    public static final int WHAT_EVENT_INSTALL_LATEST_ENGINE_PROCESS = 53;
    public static final int WHAT_GET_INSTALLED_ENGINE_LIST = 1;
    public static final int WHAT_INSTALL_LATEST_ENGINE = 3;
    public static final int WHAT_UPGRADE_ENGINE = 5;
    private static volatile Handler channelHandler;
    private String mChannelName;
    private ResultReceiver mResultReceiver;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class EngineChannelHandler extends Handler {
        public EngineChannelHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MyReceiver extends ResultReceiver {
        private Receiver mReceiver;

        public MyReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            Receiver receiver = this.mReceiver;
            if (receiver != null) {
                receiver.onReceiveData(i3, bundle);
            }
        }

        public void setReceiver(Receiver receiver) {
            this.mReceiver = receiver;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Receiver {
        void onReceiveData(int i3, Bundle bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void send(int i3, Bundle bundle) {
        ResultReceiver resultReceiver = this.mResultReceiver;
        if (resultReceiver != null) {
            resultReceiver.send(i3, bundle);
        }
    }

    public void setName(String str) {
        this.mChannelName = str;
    }

    public void setReceiver(Receiver receiver) {
        ResultReceiver resultReceiver = this.mResultReceiver;
        if (resultReceiver != null && (resultReceiver instanceof MyReceiver)) {
            ((MyReceiver) resultReceiver).setReceiver(receiver);
        }
    }

    public String toString() {
        return "EngineChannel{channelName=" + this.mChannelName + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        this.mResultReceiver.writeToParcel(parcel, i3);
        parcel.writeString(this.mChannelName);
    }

    public EngineChannel() {
        this.mChannelName = "Unknown";
        if (channelHandler == null) {
            synchronized (EngineChannel.class) {
                if (channelHandler == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("EngineChannelThread");
                    baseHandlerThread.start();
                    channelHandler = new EngineChannelHandler(baseHandlerThread.getLooper());
                }
            }
        }
        this.mResultReceiver = new MyReceiver(channelHandler);
    }

    EngineChannel(ResultReceiver resultReceiver) {
        this.mChannelName = "Unknown";
        this.mResultReceiver = resultReceiver;
    }
}
