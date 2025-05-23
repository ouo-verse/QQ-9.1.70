package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopAvatarCoverEditViewModel;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002'(B\u0007\u00a2\u0006\u0004\b$\u0010%J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002JV\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel$TroopAvatarCoverType;", "", "W1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "troopType", "", "path", "", "O1", "", "N1", "context", "type", "isEditMode", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "previewList", "index", "singlePhotoPath", "singlePhotoClipInfo", "P1", "T1", "S1", "clipInfo", "R1", "Landroid/net/Uri;", "i", "Landroid/net/Uri;", "uploadPhotoUri", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel$TroopAvatarCoverType;", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "TroopAvatarCoverType", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAvatarCoverEditViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private Uri uploadPhotoUri;

    /* renamed from: m */
    @NotNull
    private TroopAvatarCoverType type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel$TroopAvatarCoverType;", "", "(Ljava/lang/String;I)V", "COVER", "AVATAR", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class TroopAvatarCoverType extends Enum<TroopAvatarCoverType> {
        private static final /* synthetic */ TroopAvatarCoverType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TroopAvatarCoverType AVATAR;
        public static final TroopAvatarCoverType COVER;

        private static final /* synthetic */ TroopAvatarCoverType[] $values() {
            return new TroopAvatarCoverType[]{COVER, AVATAR};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57328);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            COVER = new TroopAvatarCoverType("COVER", 0);
            AVATAR = new TroopAvatarCoverType("AVATAR", 1);
            $VALUES = $values();
        }

        TroopAvatarCoverType(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TroopAvatarCoverType valueOf(String str) {
            return (TroopAvatarCoverType) Enum.valueOf(TroopAvatarCoverType.class, str);
        }

        public static TroopAvatarCoverType[] values() {
            return (TroopAvatarCoverType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel$a;", "", "", "PICK_PIC", "I", "", "TAG", "Ljava/lang/String;", "TAKE_PHOTO", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopAvatarCoverEditViewModel$a */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        public static final /* synthetic */ int[] f299804a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57329);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TroopAvatarCoverType.values().length];
            try {
                iArr[TroopAvatarCoverType.COVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopAvatarCoverType.AVATAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f299804a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b */
        final /* synthetic */ Activity f299806b;

        c(Activity activity) {
            this.f299806b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarCoverEditViewModel.this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                TroopAvatarCoverEditViewModel.this.N1(this.f299806b);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @NotNull List<Integer> r56) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) r56);
            } else {
                Intrinsics.checkNotNullParameter(r56, "results");
                super.onDenied(permissions, r56);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopAvatarCoverEditViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.type = TroopAvatarCoverType.COVER;
        }
    }

    public final void N1(Activity r46) {
        Uri profileCardUtils_enterSnapshot = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(r46, 257);
        this.uploadPhotoUri = profileCardUtils_enterSnapshot;
        QLog.i("TroopAvatarCoverEditViewModel", 1, "enterSnapshot, type=" + this.type + ", uploadPhotoUri=" + profileCardUtils_enterSnapshot);
    }

    private final boolean O1(Activity r36, int troopType, String path) {
        if (troopType == 2 || troopType == 3 || troopType == 4) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            if (options.outWidth >= 100 && options.outHeight >= 100) {
                return false;
            }
            QQToast.makeText(r36, R.string.eiq, 1).show();
            return true;
        }
        return false;
    }

    public static /* synthetic */ void Q1(TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel, Activity activity, TroopAvatarCoverType troopAvatarCoverType, boolean z16, TroopInfo troopInfo, List list, int i3, String str, String str2, int i16, Object obj) {
        int i17;
        String str3;
        String str4;
        if ((i16 & 32) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        if ((i16 & 64) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i16 & 128) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        troopAvatarCoverEditViewModel.P1(activity, troopAvatarCoverType, z16, troopInfo, list, i17, str3, str4);
    }

    public static final void U1(TroopAvatarCoverType type, AppRuntime app, Activity activity, TroopAvatarCoverEditViewModel this$0, ActionSheet this_apply, View view, int i3) {
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        QLog.i("TroopAvatarCoverEditViewModel", 1, "openPickPicActionSheet btn click type=" + type + " which=" + i3);
        if (i3 != 0) {
            if (i3 == 1) {
                ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoListEdit(activity, this$0.W1(type));
            }
        } else {
            if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isUsingCameraOnVideo(app)) {
                QQToast.makeText(activity, 0, R.string.f1787437h, 0).show();
                return;
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP, QQPermissionConstants.Business.SCENE.QQ_TROOP_PHOTO));
            Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(activity, config)");
            if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new c(activity));
            } else {
                this$0.N1(activity);
            }
        }
        this_apply.dismiss();
    }

    private final int W1(TroopAvatarCoverType troopAvatarCoverType) {
        int i3 = b.f299804a[troopAvatarCoverType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return 103;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 102;
    }

    public final void P1(@NotNull Activity context, @NotNull TroopAvatarCoverType type, boolean isEditMode, @NotNull TroopInfo troopInfo, @NotNull List<? extends TroopClipPic> previewList, int index, @Nullable String singlePhotoPath, @Nullable String singlePhotoClipInfo) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, type, Boolean.valueOf(isEditMode), troopInfo, previewList, Integer.valueOf(index), singlePhotoPath, singlePhotoClipInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(previewList, "previewList");
        QLog.i("TroopAvatarCoverEditViewModel", 1, "gotoTroopAvatarCoverPreviewPage type=" + type + " isEditMode=" + isEditMode + " troopUin=" + troopInfo.getTroopUin());
        this.type = type;
        Bundle bundle = new Bundle();
        if (type == TroopAvatarCoverType.COVER) {
            z16 = true;
        }
        bundle.putBoolean("IS_COVER", z16);
        bundle.putBoolean("IS_EDIT", isEditMode);
        bundle.putBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER, troopInfo.isMember());
        bundle.putInt("index", index);
        bundle.putString("troop_uin", troopInfo.getTroopUin());
        bundle.putLong("troop_flag_ext", troopInfo.dwGroupFlagExt);
        bundle.putBoolean("isUseClassAvatar", troopInfo.isUseClassAvatar());
        if (isEditMode) {
            bundle.putInt(ITroopUtilsApi.VISTOR_TYPE, 1);
        } else {
            bundle.putInt(ITroopUtilsApi.VISTOR_TYPE, 2);
        }
        bundle.putParcelableArrayList("PHOTO_LIST", new ArrayList<>(previewList));
        if (singlePhotoPath != null) {
            bundle.putString("PhotoConst.SINGLE_PHOTO_PATH", singlePhotoPath);
        }
        if (singlePhotoClipInfo != null) {
            bundle.putString(ITroopPhotoUtilsApi.KEY_CLIP_INFO, singlePhotoClipInfo);
        }
        Intent intent = new Intent();
        intent.setClass(context, ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopAvatarWallEditActivityClass());
        intent.putExtras(bundle);
        intent.addFlags(603979776);
        int i16 = b.f299804a[type.ordinal()];
        if (i16 != 1) {
            if (i16 == 2) {
                if (isEditMode) {
                    i3 = 260;
                } else {
                    i3 = 261;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (isEditMode) {
            i3 = 258;
        } else {
            i3 = 259;
        }
        context.startActivityForResult(intent, i3);
    }

    public final void R1(@NotNull Activity r132, @NotNull TroopInfo troopInfo, @NotNull String path, @Nullable String clipInfo) {
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, r132, troopInfo, path, clipInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(r132, "activity");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.i("TroopAvatarCoverEditViewModel", 1, "onPickPicBack type=" + this.type + " troopUin=" + troopInfo.getTroopUin());
        if (O1(r132, troopInfo.troopTypeExt, path)) {
            return;
        }
        TroopAvatarCoverType troopAvatarCoverType = this.type;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Q1(this, r132, troopAvatarCoverType, true, troopInfo, emptyList, 0, path, clipInfo, 32, null);
    }

    public final void S1(@NotNull Activity r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) r56);
            return;
        }
        Intrinsics.checkNotNullParameter(r56, "activity");
        boolean z16 = true;
        QLog.i("TroopAvatarCoverEditViewModel", 1, "onTakePhotoBack type=" + this.type + " uploadPhotoUri=" + this.uploadPhotoUri);
        Uri uri = this.uploadPhotoUri;
        if (uri != null) {
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(r56, uri);
            if (realPathFromContentURI != null && realPathFromContentURI.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit(r56, realPathFromContentURI, W1(this.type));
            }
        }
    }

    public final void T1(@NotNull final Activity r95, @NotNull final TroopAvatarCoverType type) {
        final AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) r95, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(r95, "activity");
        Intrinsics.checkNotNullParameter(type, "type");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return;
        }
        QLog.i("TroopAvatarCoverEditViewModel", 1, "openPickPicActionSheet type=" + type);
        this.type = type;
        Dialog createDialog = ActionSheetHelper.createDialog(r95, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.addButton("\u62cd\u7167", 0);
        actionSheet.addButton("\u4ece\u76f8\u518c\u9009\u62e9", 1);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopAvatarCoverEditViewModel.U1(TroopAvatarCoverEditViewModel.TroopAvatarCoverType.this, appRuntime, r95, this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }
}
