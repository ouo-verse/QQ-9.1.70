package com.tencent.mobileqq.wink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment;
import com.tencent.mobileqq.wink.intermediate.TemplateLibIntermediateFragment;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplatePreviewFragment;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewWindow;
import com.tencent.mobileqq.wink.preprocess.WinkAvatarShareTransFragment;
import com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment;
import com.tencent.mobileqq.wink.preprocess.WinkShareProcessTransFragment;
import com.tencent.mobileqq.wink.preprocess.WinkShareQQSignTransFragment;
import com.tencent.mobileqq.wink.preview.WinkLabelSharePreviewFragment;
import com.tencent.mobileqq.wink.preview.WinkPhotoWallSharePreviewFragment;
import com.tencent.mobileqq.wink.publish.fs.activity.FSUploadActivityFragment;
import com.tencent.mobileqq.wink.qzone.QZonePublishPreviewFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibDetailFragment;
import com.tencent.mobileqq.wink.utils.t;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J*\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0015\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u0018\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u001b\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJV\u0010%\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001` 2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010$\u001a\u00020\u0003JR\u0010,\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*JB\u0010.\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010-\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*J\u0016\u0010/\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ&\u00102\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/g;", "", "Ljava/util/HashMap;", "", "schemaAttrs", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "Ljava/lang/Class;", "b", "Landroid/content/Context;", "context", "", "p", "Landroid/os/Bundle;", "bundle", "d", "Landroid/content/Intent;", "intent", QZoneDTLoginReporter.SCHEMA, "o", "i", "c", "", "requestCode", "e", DomainData.DOMAIN_NAME, "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "entryBusinessName", "missionId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaPaths", "textContent", "payload", "traceId", "k", "oldPath", "newPath", MiniAppGetGameTaskTicketServlet.KEY_TASKID, IProfileCardConst.KEY_FROM_TYPE, "", "publish", "j", "description", "l", tl.h.F, "", "mediaInfoList", "f", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f322861a = new g();

    g() {
    }

    private final HashMap<String, LocalMediaInfo> a(HashMap<String, String> schemaAttrs) {
        List emptyList;
        boolean endsWith$default;
        LocalMediaInfo c16;
        boolean z16;
        HashMap<String, LocalMediaInfo> hashMap = new HashMap<>();
        String str = schemaAttrs.get("mediapath");
        Intrinsics.checkNotNull(str);
        List<String> split = new Regex(",").split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str2 : (String[]) array) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, ".mp4", false, 2, null);
            if (endsWith$default) {
                c16 = ba3.a.d(str2);
                Intrinsics.checkNotNullExpressionValue(c16, "buildLocalMediaInfosForVideo(path)");
                c16.isVideoReady = true;
                c16.missionID = UUID.randomUUID().toString();
            } else {
                c16 = ba3.a.c(str2);
                Intrinsics.checkNotNullExpressionValue(c16, "buildLocalMediaInfosForPic(path)");
            }
            hashMap.put(str2, c16);
        }
        return hashMap;
    }

    private final Class<?> b() {
        Class<?> peakTranslucentActivity = ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakTranslucentActivity();
        Intrinsics.checkNotNullExpressionValue(peakTranslucentActivity, "api(IAEClassManager::cla\u2026).peakTranslucentActivity");
        return peakTranslucentActivity;
    }

    public final void c(@Nullable Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (context == null) {
            w53.b.f("QQWinkLauncher2", "jumpToAIEliminateFragment: context is null");
            return;
        }
        w53.b.f("QQWinkLauncher2", "jumpToAIEliminateFragment: bundle=" + bundle);
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkAIEliminationFragment.class.getName());
        if (!f.f(intent)) {
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent.addFlags(268435456));
    }

    public final void d(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.containsKey("app_key");
        String string = bundle.getString(QQWinkConstants.CAPTURE_ABILITY, "all");
        if (Intrinsics.areEqual("photo", string)) {
            bundle.putInt("ability_flag", 2);
        } else if (Intrinsics.areEqual("video", string)) {
            bundle.putInt("ability_flag", 3);
        } else {
            bundle.putInt("ability_flag", 1);
        }
        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchAEMultiCamera(context, bundle);
    }

    public final void e(@Nullable Context context, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!(context instanceof Activity) || !f.f(intent)) {
            return;
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", QZonePublishPreviewFragment.class.getName());
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public final void f(@NotNull Context context, @NotNull Bundle bundle, @Nullable List<? extends LocalMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        w53.b.c("QQWinkLauncher2", "[jumpToRecommendPreview] invalid intent");
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        } else {
            intent.setFlags(603979776);
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkPhotoTemplatePreviewFragment.class.getName());
        intent.putParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList<>(mediaInfoList));
        if (!f.f(intent)) {
            return;
        }
        context.startActivity(intent);
    }

    public final void g(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        if (!f.f(intent)) {
            QLog.e("QQWinkLauncher2", 1, "[jumpToSharePreview] invalid intent");
            return;
        }
        try {
            HashMap hashMap = (HashMap) bundle.get("key_attrs");
            Intrinsics.checkNotNull(hashMap);
            String str = (String) hashMap.get(QCircleScheme.AttrQQPublish.TEMPLATE_PREVIEW_TYPE);
            if (Intrinsics.areEqual("0", str)) {
                intent.putExtra("public_fragment_class", WinkPhotoWallSharePreviewFragment.class.getName());
            } else if (Intrinsics.areEqual("2", str)) {
                intent.putExtra("public_fragment_class", WinkLabelSharePreviewFragment.class.getName());
            } else {
                QLog.e("QQWinkLauncher2", 1, "[jumpToSharePreview] invalid preview type: " + str);
            }
            context.startActivity(intent);
        } catch (Exception e16) {
            QLog.e("QQWinkLauncher2", 1, "[jumpToSharePreview]:" + e16.getMessage(), e16);
        }
    }

    public final void h(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.setClass(context, f322861a.b());
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkTemplateSharePreviewWindow.class.getName());
        if (!f.f(intent)) {
            return;
        }
        context.startActivity(intent);
    }

    public final void i(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!f.f(intent)) {
            return;
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", AIEliminateHomeFragment.class.getName());
        context.startActivity(intent);
    }

    public final void j(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @NotNull String oldPath, @NotNull String newPath, @Nullable String traceId, @NotNull String taskId, @NotNull String fromType, boolean publish) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entryBusinessName, "entryBusinessName");
        Intrinsics.checkNotNullParameter(oldPath, "oldPath");
        Intrinsics.checkNotNullParameter(newPath, "newPath");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        if (FastClickUtils.isFastDoubleClick("QQWinkLauncher2_jumpToWinkEditorAfterProcessContent_" + missionId, 500L)) {
            return;
        }
        w53.b.f("QQWinkLauncher2", "jumpToWinkEditorAfterProcessContent: missionId=" + missionId);
        Intent intent = new Intent();
        intent.setClass(context, f322861a.b());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, entryBusinessName);
        intent.putExtra(QQWinkConstants.MISSION_ID, missionId);
        intent.putExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, fromType);
        intent.putExtra(QQWinkConstants.AVATAR_ORIGIN_HD_PATH, oldPath);
        intent.putExtra(QQWinkConstants.AVATAR_NEW_HD_PATH, newPath);
        intent.putExtra(QQWinkConstants.WINK_PUBLISH_TASK_ID, taskId);
        intent.putExtra(QQWinkConstants.AVATAR_SYNC_PUBLISH, publish);
        intent.putExtra("public_fragment_class", WinkAvatarShareTransFragment.class.getName());
        intent.setFlags(268435456);
        if (!f.f(intent)) {
            return;
        }
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    public final void k(@NotNull Context context, @NotNull String entryBusinessName, @NotNull String missionId, @Nullable ArrayList<String> mediaPaths, @Nullable String textContent, @Nullable Bundle payload, @NotNull String traceId) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entryBusinessName, "entryBusinessName");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (mediaPaths != null) {
            str = CollectionsKt___CollectionsKt.joinToString$default(mediaPaths, ",", null, null, 0, null, null, 62, null);
        } else {
            str = null;
        }
        w53.b.f("QQWinkLauncher2", "jumpToWinkEditorAfterProcessContent: mediaPaths=" + str);
        Intent intent = new Intent();
        intent.setClass(context, f322861a.b());
        if (payload != null) {
            intent.putExtras(payload);
        }
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, entryBusinessName);
        intent.putExtra(QQWinkConstants.MISSION_ID, missionId);
        intent.putStringArrayListExtra(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST, mediaPaths);
        intent.putExtra(QQWinkConstants.EDITOR_TEXT_CONTENT, textContent);
        intent.putExtra("edit_image_mode", 0);
        intent.putExtra("public_fragment_class", WinkProcessContentTransFragment.class.getName());
        intent.setFlags(268435456);
        if (!f.f(intent)) {
            return;
        }
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    public final void l(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @NotNull String description, @Nullable String traceId, @NotNull String taskId, boolean publish) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entryBusinessName, "entryBusinessName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intent intent = new Intent();
        intent.setClass(context, f322861a.b());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, entryBusinessName);
        intent.putExtra(QQWinkConstants.MISSION_ID, missionId);
        intent.putExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_SIGN);
        intent.putExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.TEMPLATE_SIGN_TEXT, description);
        intent.putExtra(QQWinkConstants.WINK_PUBLISH_TASK_ID, taskId);
        intent.putExtra(QQWinkConstants.AVATAR_SYNC_PUBLISH, publish);
        intent.putExtra("public_fragment_class", WinkShareQQSignTransFragment.class.getName());
        intent.setFlags(268435456);
        if (!f.f(intent)) {
            return;
        }
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    public final void m(@Nullable Context context, @NotNull Intent intent) {
        List emptyList;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (context == null) {
            w53.b.f("QQWinkLauncher2", "jumpToWinkPublishPage: context is null");
            return;
        }
        if (FastClickUtils.isFastDoubleClick("QQWinkLauncher2_launchPublishPage", 500L)) {
            return;
        }
        w53.b.f("QQWinkLauncher2", "jumpToWinkPublish: intent=" + intent);
        if (!f.f(intent)) {
            return;
        }
        HashMap<String, String> hashMap = (HashMap) intent.getSerializableExtra("key_attrs");
        if (intent.getSerializableExtra(QQWinkConstants.INPUT_MEDIA) == null && hashMap != null && hashMap.size() > 0 && !TextUtils.isEmpty(hashMap.get("mediapath"))) {
            intent.putExtra("PeakConstants.selectedMediaInfoHashMap", a(hashMap));
        }
        if (intent.getSerializableExtra("PhotoConst.PHOTO_PATHS") == null && hashMap != null && hashMap.size() > 0) {
            String str = hashMap.get("mediapath");
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                List<String> split = new Regex(",").split(str, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (strArr != null) {
                    if (strArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (String str2 : strArr) {
                            arrayList.add(str2);
                        }
                        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
                    }
                }
            }
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", FSUploadActivityFragment.class.getName());
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, 0);
        intent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    public final void n(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!f.f(intent)) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkQZoneTemplateLibDetailFragment.class.getName());
        context.startActivity(intent);
    }

    public final void o(@NotNull Context context, @NotNull Intent intent, @Nullable String schema) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!f.f(intent)) {
            return;
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", TemplateLibIntermediateFragment.class.getName());
        context.startActivity(intent);
    }

    public final void p(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WinkPublishHelper2.INSTANCE.bindService(1, null);
        t.f326727a.c(context);
    }

    public final void q(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setClass(context, QPublicFragmentActivity.class);
        intent.putExtras(bundle);
        intent.setFlags(268435456);
        intent.putExtra("public_fragment_class", WinkShareProcessTransFragment.class.getName());
        if (!f.f(intent)) {
            return;
        }
        context.startActivity(intent);
    }
}
