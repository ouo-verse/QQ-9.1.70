package com.tencent.aelight.camera.ae.flashshow.util;

import android.app.Activity;
import android.content.Intent;
import b93.OutputData;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.model.AEDataToEditor;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002Jh\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0085\u0001\u0010\u001d\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/util/b;", "", "", "type", "", QCircleWeakNetReporter.KEY_COST, "", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "musicID", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "topic", "content", "materialName", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/model/AEDataToEditor;", "toEditorData", "a", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "musicStartTime", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "b", "(Landroid/app/Activity;ILcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;Lcom/tencent/mobileqq/wink/model/AEDataToEditor;)V", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f65103a = new b();

    b() {
    }

    private final void c(String type, long cost) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cameraShootType", type);
        hashMap.put("cameraSourceType", "QQGYCameraSourceTypeKuaiShan");
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(cost));
        com.tencent.aelight.camera.ae.report.b.b().u(hashMap);
    }

    public final void a(Activity activity, int requestCode, LocalMediaInfo mediaInfo, String musicID, String materialId, String topic, String content, String materialName, AEMaterialMetaData material, AEDataToEditor toEditorData) {
        List<? extends LocalMediaInfo> listOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        OutputData.Companion companion = OutputData.INSTANCE;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaInfo);
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        if (WinkContext.INSTANCE.d().m().k(activity, companion.a(8L, listOf, intent))) {
            return;
        }
        s.b(activity, requestCode, mediaInfo, musicID, materialId, topic, content, materialName, material, toEditorData);
        c("shoot", mq.a.d().g(IPrefRecorder.MILESTONE_CAMERA_SHOOT_JUMP_FLASH));
    }

    public final void b(Activity activity, int requestCode, LocalMediaInfo mediaInfo, WinkEditorMusicInfo musicInfo, Integer musicStartTime, Float volume, String materialId, String topic, String content, String materialName, AEMaterialMetaData material, AEDataToEditor toEditorData) {
        List<? extends LocalMediaInfo> listOf;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        OutputData.Companion companion = OutputData.INSTANCE;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaInfo);
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            intent = new Intent();
        }
        if (WinkContext.INSTANCE.d().m().k(activity, companion.a(16L, listOf, intent))) {
            return;
        }
        s.c(activity, requestCode, mediaInfo, musicInfo, musicStartTime, volume, materialId, topic, content, materialName, material, toEditorData);
        c(QQPermissionConstants.Permission.AUIDO_GROUP, mq.a.d().g(IPrefRecorder.MILESTONE_CAMERA_RECORD_JUMP_FLASH));
    }
}
