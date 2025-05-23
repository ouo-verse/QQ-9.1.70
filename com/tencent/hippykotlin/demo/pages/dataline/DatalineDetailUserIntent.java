package com.tencent.hippykotlin.demo.pages.dataline;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class DatalineDetailUserIntent {

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class AddDeskTopShortCut extends DatalineDetailUserIntent {
        public static final AddDeskTopShortCut INSTANCE = new AddDeskTopShortCut();

        public AddDeskTopShortCut() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class CheckNoWifiAutoRecvFile extends DatalineDetailUserIntent {
        public final boolean isChecked;

        public final int hashCode() {
            boolean z16 = this.isChecked;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public final String toString() {
            return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CheckNoWifiAutoRecvFile(isChecked="), this.isChecked, ')');
        }

        public CheckNoWifiAutoRecvFile(boolean z16) {
            super(null);
            this.isChecked = z16;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckNoWifiAutoRecvFile) && this.isChecked == ((CheckNoWifiAutoRecvFile) obj).isChecked;
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class CheckPCQQOnlineMention extends DatalineDetailUserIntent {
        public final boolean isChecked;

        public final int hashCode() {
            boolean z16 = this.isChecked;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public final String toString() {
            return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CheckPCQQOnlineMention(isChecked="), this.isChecked, ')');
        }

        public CheckPCQQOnlineMention(boolean z16) {
            super(null);
            this.isChecked = z16;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckPCQQOnlineMention) && this.isChecked == ((CheckPCQQOnlineMention) obj).isChecked;
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class CheckSetTop extends DatalineDetailUserIntent {
        public final boolean isChecked;

        public final int hashCode() {
            boolean z16 = this.isChecked;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public final String toString() {
            return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CheckSetTop(isChecked="), this.isChecked, ')');
        }

        public CheckSetTop(boolean z16) {
            super(null);
            this.isChecked = z16;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckSetTop) && this.isChecked == ((CheckSetTop) obj).isChecked;
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class ClearMsgRecord extends DatalineDetailUserIntent {
        public static final ClearMsgRecord INSTANCE = new ClearMsgRecord();

        public ClearMsgRecord() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class ManagerDevice extends DatalineDetailUserIntent {
        public static final ManagerDevice INSTANCE = new ManagerDevice();

        public ManagerDevice() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class QueryDownloadedFiles extends DatalineDetailUserIntent {
        public static final QueryDownloadedFiles INSTANCE = new QueryDownloadedFiles();

        public QueryDownloadedFiles() {
            super(null);
        }
    }

    public /* synthetic */ DatalineDetailUserIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public DatalineDetailUserIntent() {
    }
}
