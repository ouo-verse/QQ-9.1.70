package com.tencent.component.network.downloader.impl.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Const {
    public static final String BUNDLE_KEY_REQUEST = "request";
    public static final String BUNDLE_KEY_RESULT = "result";
    public static final String BUNDLE_KEY_URL = "url";
    public static final int MSG_WHAT_BASE = 100;
    public static final int MSG_WHAT_CLEAN_CACHE = 107;
    public static final int MSG_WHAT_DOWNLOAD_REQUEST = 101;
    public static final int MSG_WHAT_DOWNLOAD_REQUEST_ABORT = 103;
    public static final int MSG_WHAT_DOWNLOAD_REQUEST_CANCEL = 102;
    public static final int MSG_WHAT_DOWNLOAD_RESPONSE_CANCELED = 105;
    public static final int MSG_WHAT_DOWNLOAD_RESPONSE_FAILED = 104;
    public static final int MSG_WHAT_DOWNLOAD_RESPONSE_PROGRESS = 106;
    public static final int MSG_WHAT_DOWNLOAD_RESPONSE_SUCCEED = 103;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SimpleRequest implements Parcelable {
        public static final Parcelable.Creator<SimpleRequest> CREATOR = new Parcelable.Creator<SimpleRequest>() { // from class: com.tencent.component.network.downloader.impl.ipc.Const.SimpleRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SimpleRequest createFromParcel(Parcel parcel) {
                return new SimpleRequest(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SimpleRequest[] newArray(int i3) {
                return new SimpleRequest[i3];
            }
        };
        public int content_type;
        public Downloader.DownloadListener listener;
        public Downloader.DownloadMode mode;
        public List<String> pathList;
        public String url;

        public SimpleRequest() {
        }

        public void addDstPath(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.pathList == null) {
                this.pathList = new ArrayList();
            }
            if (!this.pathList.contains(str)) {
                this.pathList.add(str);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof SimpleRequest)) {
                return false;
            }
            SimpleRequest simpleRequest = (SimpleRequest) obj;
            if (this.url.equalsIgnoreCase(simpleRequest.url) && Const.equalsObject(this.listener, simpleRequest.listener)) {
                return true;
            }
            return false;
        }

        public String[] getPaths() {
            List<String> list = this.pathList;
            if (list == null) {
                return null;
            }
            String[] strArr = new String[list.size()];
            for (int i3 = 0; i3 < this.pathList.size(); i3++) {
                strArr[i3] = this.pathList.get(i3);
            }
            return strArr;
        }

        public String toString() {
            String str = "";
            if (this.pathList != null) {
                for (int i3 = 0; i3 < this.pathList.size(); i3++) {
                    str = str + this.pathList.get(i3) + ";";
                }
            }
            return new String("Download SimpleRequest: " + this.url + ", Path:" + str + ", content_type:" + this.content_type);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int i16;
            if (parcel == null) {
                return;
            }
            parcel.writeString(this.url);
            parcel.writeStringList(this.pathList);
            parcel.writeInt(this.content_type);
            if (this.mode == Downloader.DownloadMode.FastMode) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            parcel.writeInt(i16);
        }

        public SimpleRequest(Parcel parcel) {
            if (parcel == null) {
                return;
            }
            this.url = parcel.readString();
            ArrayList arrayList = new ArrayList();
            this.pathList = arrayList;
            parcel.readStringList(arrayList);
            this.content_type = parcel.readInt();
            this.mode = parcel.readInt() == 0 ? Downloader.DownloadMode.FastMode : Downloader.DownloadMode.StrictMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsObject(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static Message obtainCleanCacheMsg(String str, int i3, Messenger messenger) {
        Message obtain = Message.obtain();
        obtain.what = 107;
        obtain.replyTo = messenger;
        SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.url = str;
        simpleRequest.content_type = i3;
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_KEY_REQUEST, simpleRequest);
        obtain.setData(bundle);
        return obtain;
    }

    public static Message obtainDownloadAbortMsg(String str, int i3, Messenger messenger) {
        Message obtain = Message.obtain();
        obtain.what = 103;
        obtain.replyTo = messenger;
        SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.url = str;
        simpleRequest.content_type = i3;
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_KEY_REQUEST, simpleRequest);
        obtain.setData(bundle);
        return obtain;
    }

    public static Message obtainDownloadCancelMsg(String str, int i3, Messenger messenger) {
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.replyTo = messenger;
        SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.url = str;
        simpleRequest.content_type = i3;
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_KEY_REQUEST, simpleRequest);
        obtain.setData(bundle);
        return obtain;
    }

    public static Message obtainDownloadCanceledMsg(String str) {
        Message obtain = Message.obtain();
        obtain.what = 105;
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        obtain.setData(bundle);
        return obtain;
    }

    public static Message obtainDownloadFailedMsg(String str, DownloadResult downloadResult) {
        Message obtain = Message.obtain();
        obtain.what = 104;
        Bundle bundle = new Bundle();
        bundle.putParcelable("result", downloadResult);
        obtain.setData(bundle);
        return obtain;
    }

    public static Message obtainDownloadProgressMsg(String str, long j3, float f16) {
        Message obtain = Message.obtain();
        obtain.what = 106;
        obtain.arg1 = (int) j3;
        obtain.arg2 = (int) f16;
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        obtain.setData(bundle);
        return obtain;
    }

    public static Message obtainDownloadRequestMsg(String str, String[] strArr, int i3, Downloader.DownloadMode downloadMode, Messenger messenger) {
        Message obtain = Message.obtain();
        obtain.what = 101;
        obtain.replyTo = messenger;
        SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.url = str;
        simpleRequest.content_type = i3;
        simpleRequest.mode = downloadMode;
        if (strArr != null) {
            for (String str2 : strArr) {
                simpleRequest.addDstPath(str2);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_KEY_REQUEST, simpleRequest);
        obtain.setData(bundle);
        return obtain;
    }

    public static Message obtainDownloadSucceedMsg(String str, DownloadResult downloadResult) {
        Message obtain = Message.obtain();
        obtain.what = 103;
        Bundle bundle = new Bundle();
        bundle.putParcelable("result", downloadResult);
        obtain.setData(bundle);
        return obtain;
    }
}
