package com.tencent.mobileqq.friend.data;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.state.data.SquareJSConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b%\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0085\u0001\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0002j\b\u0012\u0004\u0012\u00020\n`\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0018\u0012\b\b\u0002\u0010\"\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u0018\u0012\b\b\u0002\u00101\u001a\u00020\u0018\u0012\b\b\u0002\u00104\u001a\u00020\u0012\u0012\b\b\u0002\u00106\u001a\u00020\u0018\u00a2\u0006\u0004\b9\u0010:J\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004J\b\u0010\u000b\u001a\u00020\nH\u0016R2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0002j\b\u0012\u0004\u0012\u00020\n`\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\"\u0010%\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\"\u0010(\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\"\u00101\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR\"\u00104\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\"\u00106\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u001a\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001e\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/friend/data/FriendListRequestData;", "Ljava/io/Serializable;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getUinListParam", "", "getIfReflushParam", "getIfGetGroupInfoParam", "getSNSTypeList", "", "toString", SquareJSConst.Params.PARAMS_UIN_LIST, "Ljava/util/ArrayList;", "getUinList", "()Ljava/util/ArrayList;", "setUinList", "(Ljava/util/ArrayList;)V", "", "isRequestSingle", "Z", "()Z", "setRequestSingle", "(Z)V", "", FriendListHandler.PARAMS_FRIEND_START_INDEX, "I", "getFriendStartIndex", "()I", "setFriendStartIndex", "(I)V", "friendCount", "getFriendCount", "setFriendCount", "groupStartIndex", "getGroupStartIndex", "setGroupStartIndex", "groupCount", "getGroupCount", "setGroupCount", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "J", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "totalFriendCount", "getTotalFriendCount", "setTotalFriendCount", "showTermType", "getShowTermType", "setShowTermType", "isPullRefresh", "setPullRefresh", "ntFriendListSeq", "getNtFriendListSeq", "setNtFriendListSeq", "<init>", "(Ljava/util/ArrayList;ZIIIIJIIZI)V", "Companion", "a", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FriendListRequestData implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int FIRST_GET_FRIEND_NUM = 20;
    public static final int GET_FRIEND_NUM = 200;
    public static final int GET_GROUP_NUM = 100;
    private int friendCount;
    private int friendStartIndex;
    private int groupCount;
    private int groupStartIndex;
    private boolean isPullRefresh;
    private boolean isRequestSingle;
    private int ntFriendListSeq;
    private int showTermType;
    private long timeStamp;
    private int totalFriendCount;

    @NotNull
    private ArrayList<String> uinList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/friend/data/FriendListRequestData$a;", "", "", "FIRST_GET_FRIEND_NUM", "I", "GET_FRIEND_NUM", "GET_GROUP_NUM", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.data.FriendListRequestData$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34104);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FriendListRequestData() {
        this(null, false, 0, 0, 0, 0, 0L, 0, 0, false, 0, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            return;
        }
        iPatchRedirector.redirect((short) 30, (Object) this);
    }

    public final int getFriendCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.friendCount;
    }

    public final int getFriendStartIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.friendStartIndex;
    }

    public final int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.groupCount;
    }

    public final int getGroupStartIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.groupStartIndex;
    }

    public final byte getIfGetGroupInfoParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Byte) iPatchRedirector.redirect((short) 27, (Object) this)).byteValue();
        }
        if (this.isRequestSingle || this.friendStartIndex > 0) {
            return (byte) 0;
        }
        return (byte) 1;
    }

    public final byte getIfReflushParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Byte) iPatchRedirector.redirect((short) 26, (Object) this)).byteValue();
        }
        if (this.isRequestSingle || this.friendStartIndex <= 0) {
            return (byte) 1;
        }
        return (byte) 0;
    }

    public final int getNtFriendListSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.ntFriendListSeq;
    }

    @Nullable
    public final ArrayList<Long> getSNSTypeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (ArrayList) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        if (!this.isRequestSingle) {
            ArrayList<Long> arrayList = new ArrayList<>(3);
            arrayList.add(13580L);
            arrayList.add(13581L);
            arrayList.add(13582L);
            return arrayList;
        }
        return null;
    }

    public final int getShowTermType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.showTermType;
    }

    public final long getTimeStamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.timeStamp;
    }

    public final int getTotalFriendCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.totalFriendCount;
    }

    @NotNull
    public final ArrayList<String> getUinList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uinList;
    }

    @Nullable
    public final ArrayList<Long> getUinListParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ArrayList) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (!this.isRequestSingle) {
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            if (!this.uinList.isEmpty()) {
                Iterator<String> it = this.uinList.iterator();
                while (it.hasNext()) {
                    String uinStr = it.next();
                    Intrinsics.checkNotNullExpressionValue(uinStr, "uinStr");
                    arrayList.add(Long.valueOf(Long.parseLong(uinStr)));
                }
            }
        } catch (NumberFormatException e16) {
            QLog.e("FriendListRequestData", 1, "getUinListParam", e16);
        }
        return arrayList;
    }

    public final boolean isPullRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.isPullRefresh;
    }

    public final boolean isRequestSingle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isRequestSingle;
    }

    public final void setFriendCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.friendCount = i3;
        }
    }

    public final void setFriendStartIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.friendStartIndex = i3;
        }
    }

    public final void setGroupCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.groupCount = i3;
        }
    }

    public final void setGroupStartIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.groupStartIndex = i3;
        }
    }

    public final void setNtFriendListSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.ntFriendListSeq = i3;
        }
    }

    public final void setPullRefresh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.isPullRefresh = z16;
        }
    }

    public final void setRequestSingle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isRequestSingle = z16;
        }
    }

    public final void setShowTermType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.showTermType = i3;
        }
    }

    public final void setTimeStamp(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.timeStamp = j3;
        }
    }

    public final void setTotalFriendCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.totalFriendCount = i3;
        }
    }

    public final void setUinList(@NotNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.uinList = arrayList;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return "FriendListRequest(uinListSize='" + this.uinList.size() + "', friendStartIndex=" + this.friendStartIndex + ", friendCount=" + this.friendCount + ", groupStartIndex=" + this.groupStartIndex + ", groupCount=" + this.groupCount + ", timeStamp=" + this.timeStamp + ", totalFriendCount=" + this.totalFriendCount + ", showTermType=" + this.showTermType + ", isPullRefresh=" + this.isPullRefresh + ')';
    }

    public FriendListRequestData(@NotNull ArrayList<String> uinList, boolean z16, int i3, int i16, int i17, int i18, long j3, int i19, int i26, boolean z17, int i27) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uinList, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3), Integer.valueOf(i19), Integer.valueOf(i26), Boolean.valueOf(z17), Integer.valueOf(i27));
            return;
        }
        this.uinList = uinList;
        this.isRequestSingle = z16;
        this.friendStartIndex = i3;
        this.friendCount = i16;
        this.groupStartIndex = i17;
        this.groupCount = i18;
        this.timeStamp = j3;
        this.totalFriendCount = i19;
        this.showTermType = i26;
        this.isPullRefresh = z17;
        this.ntFriendListSeq = i27;
    }

    public /* synthetic */ FriendListRequestData(ArrayList arrayList, boolean z16, int i3, int i16, int i17, int i18, long j3, int i19, int i26, boolean z17, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this((i28 & 1) != 0 ? new ArrayList() : arrayList, (i28 & 2) != 0 ? false : z16, (i28 & 4) != 0 ? 0 : i3, (i28 & 8) != 0 ? 0 : i16, (i28 & 16) != 0 ? 0 : i17, (i28 & 32) != 0 ? 0 : i18, (i28 & 64) != 0 ? 0L : j3, (i28 & 128) != 0 ? 0 : i19, (i28 & 256) != 0 ? 0 : i26, (i28 & 512) != 0 ? false : z17, (i28 & 1024) != 0 ? 0 : i27);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, arrayList, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3), Integer.valueOf(i19), Integer.valueOf(i26), Boolean.valueOf(z17), Integer.valueOf(i27), Integer.valueOf(i28), defaultConstructorMarker);
    }
}
