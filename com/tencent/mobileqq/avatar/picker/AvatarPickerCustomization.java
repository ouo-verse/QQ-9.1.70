package com.tencent.mobileqq.avatar.picker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.peak.PeakConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/avatar/picker/AvatarPickerCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "", "path", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "startCropAct", "registerBroadcast", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "layoutPosition", "onItemClickEvent", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AvatarPickerCustomization extends PickerCustomizationBase<a> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AvatarPickerCustomization";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/avatar/picker/AvatarPickerCustomization$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.picker.AvatarPickerCustomization$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPickerCustomization(@NotNull FragmentActivity activity, @NotNull b<a> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) photoCommonData);
        } else {
            registerBroadcast();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.tencent.mobileqq.avatar.picker.AvatarPickerCustomization$registerBroadcast$receiver$1, android.content.BroadcastReceiver] */
    private final void registerBroadcast() {
        boolean z16;
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME);
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "registerBroadcast empty actionName");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(stringExtra);
        final ?? r46 = new BroadcastReceiver(stringExtra, this) { // from class: com.tencent.mobileqq.avatar.picker.AvatarPickerCustomization$registerBroadcast$receiver$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f200131a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AvatarPickerCustomization f200132b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f200131a = stringExtra;
                this.f200132b = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) stringExtra, (Object) this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent2);
                    return;
                }
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent2, "intent");
                String action = intent2.getAction();
                if (Intrinsics.areEqual(this.f200131a, action)) {
                    QLog.i("AvatarPickerCustomization", 1, "onReceive broadcast. finish activity");
                    this.f200132b.getActivity().finish();
                    return;
                }
                QLog.i("AvatarPickerCustomization", 1, "ignore action: " + action + ", want action: " + this.f200131a);
            }
        };
        try {
            getActivity().registerReceiver(r46, intentFilter);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "registerBroadcast exception ", e16);
        }
        getActivity().getLifecycle().addObserver(new LifecycleEventObserver(r46) { // from class: com.tencent.mobileqq.avatar.picker.AvatarPickerCustomization$registerBroadcast$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AvatarPickerCustomization$registerBroadcast$receiver$1 f200130e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f200130e = r46;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarPickerCustomization.this, (Object) r46);
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) source, (Object) event);
                    return;
                }
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    try {
                        AvatarPickerCustomization.this.getActivity().unregisterReceiver(this.f200130e);
                    } catch (Exception e17) {
                        QLog.e("AvatarPickerCustomization", 1, "onStateChanged unregisterReceiver exception", e17);
                    }
                }
            }
        });
    }

    private final void startCropAct(String path, Uri uri) {
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", path);
        if (uri != null) {
            intent.putExtra(PeakConstants.CROP_SINGLE_PHOTO_URI, uri);
        }
        intent.setClass(getActivity(), PhotoCropForPortraitActivity.class);
        intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
        intent.putExtra(PeakConstants.TARGET_PATH, FaceUtil.getUploadAvatarTempPath());
        int x16 = ProfileCardUtil.x(getActivity());
        intent.putExtra(PeakConstants.CLIP_WIDTH, x16);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, x16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, 1080);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, 1080);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.addFlags(603979776);
        getActivity().startActivity(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onItemClickEvent(@NotNull View view, @NotNull LocalMediaInfo mediaInfo, int layoutPosition) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, mediaInfo, Integer.valueOf(layoutPosition));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String path = mediaInfo.getPath();
        Uri a16 = com.tencent.mobileqq.album.media.b.a(mediaInfo);
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i(TAG, 1, "checkFilePathValid path is empty");
            return;
        }
        File file = new File(path);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "onItemClickEvent path: " + path + ", uri: " + a16);
        }
        if (file.exists() && file.canRead()) {
            z17 = true;
        }
        if (!z17) {
            QLog.e(TAG, 1, "onItemClickEvent file error. exists? " + file.exists() + ", canRead? " + file.canRead());
        }
        if (a16 == null) {
            QLog.e(TAG, 1, "onItemClickEvent uri is null");
        }
        if (z17 || a16 != null) {
            startCropAct(path, a16);
        }
    }
}
