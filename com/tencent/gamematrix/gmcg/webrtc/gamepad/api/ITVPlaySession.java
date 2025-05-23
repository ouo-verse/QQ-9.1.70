package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

/* loaded from: classes6.dex */
public interface ITVPlaySession {

    /* loaded from: classes6.dex */
    public enum ErrorCode {
        None(0),
        OpenFailed(-1),
        OpenConnectFailed(-2),
        ReConnectFailed(-3),
        ConnectFailed(-4),
        Exception(-5),
        DeviceException(-6),
        DeviceManagerLost(-7),
        PermissionDenied(-8);

        int mErrorCode;

        ErrorCode(int i3) {
            this.mErrorCode = i3;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    /* loaded from: classes6.dex */
    public enum GamepadReportStatus {
        None("None"),
        OpenFailed("OpenFailed"),
        OpenConnectFailed("OpenConnectFailed"),
        ReConnectFailed("ReConnectFailed"),
        ConnectFailed("ConnectFailed"),
        Exception("Exception"),
        DeviceException("DeviceException"),
        DeviceManagerLost("DeviceManagerLost"),
        PermissionDenied("PermissionDenied");

        String mName;

        GamepadReportStatus(String str) {
            this.mName = str;
        }

        public String getStatus() {
            return this.mName;
        }
    }

    /* loaded from: classes6.dex */
    public enum ReportName {
        None("None"),
        Gamepad("Gamepad"),
        CustomGamepad("CustomGamepad");

        String mName;

        ReportName(String str) {
            this.mName = str;
        }

        public String getName() {
            return this.mName;
        }
    }

    void reportTVGamepadStatus(String str, int i3, String str2);
}
