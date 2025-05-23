package com.tencent.mobileqq.troop.teamup.detail.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.i;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J3\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J&\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/common/TroopTeamUploadPicUtils;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "permissions", "Lkotlin/Function0;", "", "granted", "d", "(Landroid/app/Activity;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "size", "", "a", "g", "", "reqCode", "maxNum", "e", "Landroid/content/Context;", "context", "f", "Landroid/content/Intent;", "intent", "b", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/i;", "c", "[Ljava/lang/String;", "storagePermissions", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUploadPicUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopTeamUploadPicUtils f298872a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] storagePermissions;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/teamup/detail/common/TroopTeamUploadPicUtils$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f298874a;

        a(Function0<Unit> function0) {
            this.f298874a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                this.f298874a.invoke();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f298872a = new TroopTeamUploadPicUtils();
            storagePermissions = new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
        }
    }

    TroopTeamUploadPicUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(long size) {
        if (size < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            return true;
        }
        return false;
    }

    private final void d(Activity activity, String[] permissions, Function0<Unit> granted) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK));
        ArrayList arrayList = new ArrayList(permissions.length);
        int length = permissions.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                break;
            }
            if (qQPermission.hasPermission(permissions[i3]) != 0) {
                z16 = false;
            }
            arrayList.add(Boolean.valueOf(z16));
            i3++;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((Boolean) obj).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.size() == 0) {
            granted.invoke();
        } else {
            qQPermission.requestPermissions(permissions, 2, new a(granted));
        }
    }

    private final void g() {
        ToastUtil.a().e("\u4e0a\u4f20\u9650\u5236\u6700\u5927100M");
    }

    public final boolean b(@NotNull Intent intent, int reqCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, reqCode)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getIntExtra("req_select_media", 0) != reqCode) {
            return false;
        }
        return true;
    }

    @NotNull
    public final i c(@NotNull Intent intent) {
        boolean z16;
        HashMap hashMap;
        int collectionSizeOrDefault;
        int mediaType;
        long j3;
        boolean z17;
        int i3;
        int i16;
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (i) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("TroopTeamUploadPicUtils", 1, "selected data is empty.");
            return new i(new ArrayList());
        }
        Serializable serializableExtra = intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        Object obj = null;
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new LinkedHashMap();
        }
        Iterator<T> it = stringArrayListExtra.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TroopTeamUploadPicUtils troopTeamUploadPicUtils = f298872a;
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) hashMap.get((String) next);
            if (localMediaInfo != null) {
                j17 = localMediaInfo.fileSize;
            } else {
                j17 = 0;
            }
            if (!troopTeamUploadPicUtils.a(j17)) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            g();
        }
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj2 : stringArrayListExtra) {
            TroopTeamUploadPicUtils troopTeamUploadPicUtils2 = f298872a;
            LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) hashMap.get((String) obj2);
            if (localMediaInfo2 != null) {
                j16 = localMediaInfo2.fileSize;
            } else {
                j16 = 0;
            }
            if (troopTeamUploadPicUtils2.a(j16)) {
                arrayList.add(obj2);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (String it5 : arrayList) {
            if (hashMap.containsKey(it5)) {
                mediaType = QAlbumUtil.getMediaType((LocalMediaInfo) hashMap.get(it5));
            } else {
                mediaType = QAlbumUtil.getMediaType(it5);
            }
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            LocalMediaInfo localMediaInfo3 = (LocalMediaInfo) hashMap.get(it5);
            if (localMediaInfo3 != null) {
                j3 = localMediaInfo3.fileSize;
            } else {
                j3 = 0;
            }
            if (mediaType == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            LocalMediaInfo localMediaInfo4 = (LocalMediaInfo) hashMap.get(it5);
            if (localMediaInfo4 != null) {
                i3 = localMediaInfo4.mediaWidth;
            } else {
                i3 = 0;
            }
            LocalMediaInfo localMediaInfo5 = (LocalMediaInfo) hashMap.get(it5);
            if (localMediaInfo5 != null) {
                i16 = localMediaInfo5.mediaHeight;
            } else {
                i16 = 0;
            }
            arrayList2.add(new h(it5, j3, z17, i3, i16));
        }
        return new i(arrayList2);
    }

    public final void e(@NotNull final Activity activity, final int reqCode, final int maxNum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, Integer.valueOf(reqCode), Integer.valueOf(maxNum));
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            d(activity, storagePermissions, new Function0<Unit>(activity, maxNum, reqCode) { // from class: com.tencent.mobileqq.troop.teamup.detail.common.TroopTeamUploadPicUtils$startSelectMedia$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ int $maxNum;
                final /* synthetic */ int $reqCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$activity = activity;
                    this.$maxNum = maxNum;
                    this.$reqCode = reqCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, activity, Integer.valueOf(maxNum), Integer.valueOf(reqCode));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    InputMethodUtil.hide(this.$activity);
                    ITroopHWApi iTroopHWApi = (ITroopHWApi) QRoute.api(ITroopHWApi.class);
                    int i3 = this.$maxNum;
                    Activity activity2 = this.$activity;
                    AppInterface e16 = bg.e();
                    Intent selectMediaIntent = iTroopHWApi.getSelectMediaIntent(i3, activity2, e16 != null ? e16.getCurrentAccountUin() : null);
                    int i16 = this.$reqCode;
                    selectMediaIntent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
                    selectMediaIntent.putExtra("req_select_media", i16);
                    selectMediaIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
                    this.$activity.startActivityForResult(selectMediaIntent, this.$reqCode);
                }
            });
        }
    }

    public final void f(@NotNull final Activity activity, @NotNull final Context context, final int reqCode, final int maxNum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, context, Integer.valueOf(reqCode), Integer.valueOf(maxNum));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(context, "context");
        d(activity, storagePermissions, new Function0<Unit>(activity, maxNum, context, reqCode) { // from class: com.tencent.mobileqq.troop.teamup.detail.common.TroopTeamUploadPicUtils$startSelectMediaV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity $activity;
            final /* synthetic */ Context $context;
            final /* synthetic */ int $maxNum;
            final /* synthetic */ int $reqCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$activity = activity;
                this.$maxNum = maxNum;
                this.$context = context;
                this.$reqCode = reqCode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, activity, Integer.valueOf(maxNum), context, Integer.valueOf(reqCode));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                InputMethodUtil.hide(this.$activity);
                this.$activity.startActivityForResult(new com.tencent.mobileqq.troop.homework.album.a().e(this.$maxNum, this.$context, true), this.$reqCode);
            }
        });
    }
}
