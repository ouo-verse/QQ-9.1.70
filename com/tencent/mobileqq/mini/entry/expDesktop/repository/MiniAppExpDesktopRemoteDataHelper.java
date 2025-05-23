package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.studymode.StudyModeManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopRemoteDataHelper;", "", "()V", "hasGdtCookie", "", "extInfo", "LNS_COMM/COMM$StCommonExt;", "setExtInfoGdtCookie", "", "setExtInfoTeenager", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRemoteDataHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_TEENAGER_REQUEST_PARAM = "teenager";
    private static final String TAG = "MiniAppDesktopRemoteDataHelper";
    private static final String VALUE_TEENAGER_REQUEST_PARAM = "1";
    private static MiniAppExpDesktopRemoteDataHelper mInstance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopRemoteDataHelper$Companion;", "", "()V", "KEY_TEENAGER_REQUEST_PARAM", "", "TAG", "VALUE_TEENAGER_REQUEST_PARAM", "mInstance", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopRemoteDataHelper;", "getInstance", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniAppExpDesktopRemoteDataHelper getInstance() {
            if (MiniAppExpDesktopRemoteDataHelper.mInstance == null) {
                MiniAppExpDesktopRemoteDataHelper.mInstance = new MiniAppExpDesktopRemoteDataHelper();
            }
            MiniAppExpDesktopRemoteDataHelper miniAppExpDesktopRemoteDataHelper = MiniAppExpDesktopRemoteDataHelper.mInstance;
            Intrinsics.checkNotNull(miniAppExpDesktopRemoteDataHelper, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopRemoteDataHelper");
            return miniAppExpDesktopRemoteDataHelper;
        }

        Companion() {
        }
    }

    private final boolean hasGdtCookie(COMM.StCommonExt extInfo) {
        PBRepeatMessageField<COMM.Entry> pBRepeatMessageField = extInfo.mapInfo;
        if (pBRepeatMessageField == null) {
            return false;
        }
        List<COMM.Entry> list = pBRepeatMessageField.get();
        Intrinsics.checkNotNullExpressionValue(list, "extInfo.mapInfo.get()");
        for (COMM.Entry entry : list) {
            if (entry.get() != null && "gdt_cookie".equals(entry.key)) {
                return true;
            }
        }
        return false;
    }

    public final void setExtInfoGdtCookie(COMM.StCommonExt extInfo) {
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        if (hasGdtCookie(extInfo)) {
            COMM.Entry entry = new COMM.Entry();
            entry.key.set("gdt_cookie");
            entry.value.set(MiniAppUtils.getSpDesktopGdtCookie());
            extInfo.mapInfo.get().add(entry);
        }
    }

    public final void setExtInfoTeenager(COMM.StCommonExt extInfo) {
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        if (StudyModeManager.t()) {
            COMM.Entry entry = new COMM.Entry();
            entry.key.set("teenager");
            entry.value.set("1");
            extInfo.mapInfo.get().add(entry);
        }
    }
}
