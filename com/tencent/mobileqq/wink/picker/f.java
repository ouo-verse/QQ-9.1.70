package com.tencent.mobileqq.wink.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.aieliminate.picker.AIEliminateSingleMediaPickerFragment;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.magicAvatar.picker.AEMagicAvatarPickerDelegateFragment;
import com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarSingleMediaPickerFragment;
import com.tencent.mobileqq.wink.magicstudio.picker.MagicStudioSingleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.ae.AESingleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleAvatarPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleCommentMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleDefaultMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qzone.album.QZoneAlbumMediaPickerFragment;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J>\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J>\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J>\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J>\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J&\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ8\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\n2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ,\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00102\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/f;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", tl.h.F, "Landroidx/fragment/app/Fragment;", "fragment", "", "requestCode", "", "traceId", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Landroid/os/Bundle;", "extra", "a", "f", "c", "e", "oldPath", "d", "sourceIntent", "alreadySelectedMediaCount", "", "Lcom/tencent/mobileqq/wink/picker/MediaInfo;", "selectedMedia", "j", "i", "bundle", "Ljava/util/HashMap;", "keyAttrs", "g", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f324854a = new f();

    f() {
    }

    public static /* synthetic */ void b(f fVar, Context context, Fragment fragment, int i3, String str, Config config, Bundle bundle, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i16 & 32) != 0) {
            bundle = null;
        }
        fVar.a(context, fragment, i3, str2, config, bundle);
    }

    public final void a(@NotNull Context context, @Nullable Fragment fragment, int requestCode, @NotNull String traceId, @NotNull Config config, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", AESingleMediaPickerFragment.class.getName());
        intent.putExtras(UniversalMediaPickerFragment.Companion.b(UniversalMediaPickerFragment.INSTANCE, config, null, 2, null));
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        if (extra != null) {
            intent.putExtra(AECameraConstants.FRAGMENT_EXTRA_DATA, extra);
        }
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    public final void c(@NotNull Context context, @Nullable Fragment fragment, int requestCode, @NotNull String traceId, @NotNull Config config, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intent intent = new Intent();
        if (extra != null) {
            intent.putExtras(extra);
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", AIEliminateSingleMediaPickerFragment.class.getName());
        intent.putExtras(UniversalMediaPickerFragment.Companion.b(UniversalMediaPickerFragment.INSTANCE, config, null, 2, null));
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        if (WinkContext.INSTANCE.d().u("QCIRCLE")) {
            ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).addUseProfileThemeFlag(intent);
        }
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    public final void d(@NotNull Context context, @NotNull String oldPath, int requestCode, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldPath, "oldPath");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", QCircleAvatarPickerFragment.class.getName());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE_AVATAR");
        intent.putExtra(QQWinkConstants.AVATAR_OLD_HD_PATH, oldPath);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    public final void e(@NotNull Context context, @Nullable Fragment fragment, int requestCode, @NotNull String traceId, @NotNull Config config, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", MagicAvatarSingleMediaPickerFragment.class.getName());
        intent.putExtra(QQWinkConstants.KEY_PICKER_FRAGMENT_CLASS, AEMagicAvatarPickerDelegateFragment.class.getName());
        intent.putExtras(UniversalMediaPickerFragment.Companion.b(UniversalMediaPickerFragment.INSTANCE, config, null, 2, null));
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        if (extra != null) {
            intent.putExtra(AECameraConstants.FRAGMENT_EXTRA_DATA, extra);
        }
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    public final void f(@NotNull Context context, @Nullable Fragment fragment, int requestCode, @NotNull String traceId, @NotNull Config config, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", MagicStudioSingleMediaPickerFragment.class.getName());
        intent.putExtras(UniversalMediaPickerFragment.Companion.b(UniversalMediaPickerFragment.INSTANCE, config, null, 2, null));
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        if (WinkContext.INSTANCE.d().u("QCIRCLE")) {
            ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).addUseProfileThemeFlag(intent);
        }
        if (extra != null) {
            intent.putExtra(AECameraConstants.FRAGMENT_EXTRA_DATA, extra);
        }
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    public final void g(@NotNull Context context, @NotNull Bundle bundle, @Nullable HashMap<String, String> keyAttrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        int i3 = bundle.getInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, 1);
        intent.putExtra("public_fragment_class", QCircleCommentMediaPickerFragment.class.getName());
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i3);
        } else {
            context.startActivity(intent);
        }
    }

    public final void h(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        w53.b.f("WinkMediaPickerNavigator2", "jumpToQCircleDefaultMediaPicker: intent=" + intent);
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        if (Intrinsics.areEqual("QZONE", intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME))) {
            intent.putExtra("public_fragment_class", QZoneMediaPickerFragment.class.getName());
        } else {
            intent.putExtra("public_fragment_class", QCircleDefaultMediaPickerFragment.class.getName());
        }
        if (!com.tencent.mobileqq.wink.f.f(intent)) {
            return;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, intent.getIntExtra(QQWinkConstants.ACTIVITY_REQUEST_CODE, 0));
            activity.overridePendingTransition(R.anim.f155067i2, R.anim.f154550b4);
            return;
        }
        context.startActivity(intent);
    }

    public final void i(@NotNull Context context, @NotNull Intent intent, int requestCode) {
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra("public_fragment_class", QZoneAlbumMediaPickerFragment.class.getName());
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    public final void j(@NotNull Context context, @Nullable Intent sourceIntent, int alreadySelectedMediaCount, @Nullable List<MediaInfo> selectedMedia, int requestCode) {
        boolean z16;
        Intent intent = sourceIntent;
        Intrinsics.checkNotNullParameter(context, "context");
        w53.b.f("WinkMediaPickerNavigator2", "jumpToWinkPick: intent=" + intent);
        if (intent == null) {
            intent = new Intent();
        }
        TabType tabType = TabType.ALL_MEDIA;
        Activity activity = null;
        int i3 = 500;
        if (intent.getBooleanExtra("param_parse_schema_params", false)) {
            Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
            if (serializableExtra instanceof Map) {
                com.tencent.mobileqq.wink.schema.d.f326305a.a((Map) serializableExtra, intent, null);
            }
            String stringExtra = intent.getStringExtra(QCircleScheme.AttrQQPublish.QZONE_ALBUM_MAX_SELECTION_COUNT);
            if (stringExtra != null) {
                i3 = Integer.parseInt(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra(QCircleScheme.AttrQQPublish.QZONE_ALBUM_MEDIA_TYPE);
            if (stringExtra2 == null) {
                stringExtra2 = "0";
            }
            z16 = Intrinsics.areEqual(intent.getStringExtra(QCircleScheme.AttrQQPublish.QZONE_ALBUM_ENABLE_EDIT), "1");
            if (Intrinsics.areEqual(stringExtra2, "1")) {
                tabType = TabType.ONLY_IMAGE;
            } else if (Intrinsics.areEqual(stringExtra2, "2")) {
                tabType = TabType.ONLY_VIDEO;
            }
        } else {
            z16 = true;
        }
        boolean z17 = z16;
        boolean booleanExtra = intent.getBooleanExtra(QQWinkConstants.KEY_IS_FROM_CLIP, false);
        QZoneAlbumMediaPickerFragment.Companion companion = QZoneAlbumMediaPickerFragment.INSTANCE;
        Config.Companion companion2 = Config.INSTANCE;
        Config.a aVar = new Config.a();
        if (selectedMedia != null) {
            aVar.c(selectedMedia);
        }
        aVar.p(alreadySelectedMediaCount);
        aVar.j(i3);
        aVar.m(tabType);
        aVar.i(tabType);
        intent.putExtras(companion.a(aVar.a(), new QZoneInitBean(false, 0, 0, false, 0, 0, 0, booleanExtra, null, false, z17, false, false, 7031, null)));
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra("public_fragment_class", QZoneAlbumMediaPickerFragment.class.getName());
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null) {
            activity.startActivityForResult(intent, requestCode);
        }
    }
}
