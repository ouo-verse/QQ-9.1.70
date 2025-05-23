package com.tencent.mobileqq.wink.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPickerFragment;
import com.tencent.mobileqq.wink.qzone.imagetemplate.WinkImageTemplateMediaPickerFragment;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.utils.n;
import com.tencent.mobileqq.wink.utils.o;
import cooperation.peak.PeakConstants;
import e93.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.light.ClipPlaceHolder;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J:\u0010\u0019\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b`\u0017H\u0002J$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ(\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001dJ\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0016J\u0016\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/g;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "fromIntent", "Lcom/tencent/mobileqq/wink/picker/b;", "mediaPickerOutput", "", "d", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "toIntent", "a", "intent", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "c", QAdVrReportParams.ParamKey.MEDIA, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pathToInfo", "b", "g", "requestCode", "traceId", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, tl.h.F, "f", "Landroid/os/Bundle;", "bundle", "e", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f324860a = new g();

    g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<LocalMediaInfo> a(List<? extends LocalMediaInfo> selectedMedia, Intent toIntent) {
        List mutableList;
        boolean z16;
        int l3;
        List<LocalMediaInfo> list;
        MetaMaterial metaMaterial = (MetaMaterial) toIntent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (metaMaterial != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) selectedMedia);
            int c16 = c(toIntent, metaMaterial) - mutableList.size();
            for (int i3 = 0; i3 < c16; i3++) {
                LocalMediaInfo a16 = ba3.a.a();
                Intrinsics.checkNotNullExpressionValue(a16, "buildLocalMediaInfoForEmptyPlaceholder()");
                mutableList.add(a16);
            }
            List list2 = mutableList;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (i.D((LocalMediaInfo) it.next())) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                return selectedMedia;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : selectedMedia) {
                if (!i.D((LocalMediaInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (com.tencent.mobileqq.wink.editor.c.l(metaMaterial) >= arrayList.size()) {
                l3 = 0;
            } else {
                l3 = com.tencent.mobileqq.wink.editor.c.l(metaMaterial);
            }
            int size = arrayList.size();
            while (l3 < size) {
                if (l3 >= 0) {
                    if (com.tencent.mobileqq.wink.editor.c.m(metaMaterial) != -1 && com.tencent.mobileqq.wink.editor.c.m(metaMaterial) <= arrayList2.size()) {
                        break;
                    }
                    arrayList2.add(arrayList.get(l3));
                }
                l3++;
            }
            if (arrayList2.isEmpty()) {
                w53.b.c("WinkMediaPickerNavigator", "autoFillEmptyPlaceholders failed: ");
                return selectedMedia;
            }
            int size2 = mutableList.size();
            int i16 = 0;
            for (int i17 = 0; i17 < size2; i17++) {
                if (i.D((LocalMediaInfo) mutableList.get(i17))) {
                    mutableList.set(i17, i.b((LocalMediaInfo) arrayList2.get(i16 % arrayList2.size())));
                    i16++;
                }
            }
            toIntent.putExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL, new ArrayList(mutableList));
            list = CollectionsKt___CollectionsKt.toList(list2);
            return list;
        }
        return selectedMedia;
    }

    private final void b(List<? extends LocalMediaInfo> media, HashMap<String, LocalMediaInfo> pathToInfo) {
        for (LocalMediaInfo localMediaInfo : media) {
            localMediaInfo.isVideoReady = true;
            localMediaInfo.missionID = UUID.randomUUID().toString();
            String str = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str, "it.path");
            pathToInfo.put(str, localMediaInfo);
        }
    }

    private final int c(Intent intent, MetaMaterial material) {
        ArrayList arrayList;
        Serializable serializableExtra = intent.getSerializableExtra("template_holder_slot");
        if (serializableExtra instanceof ArrayList) {
            arrayList = (ArrayList) serializableExtra;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            return arrayList.size();
        }
        List<ClipPlaceHolder> a16 = n.f326718a.a(material);
        if (a16 != null) {
            return a16.size();
        }
        return -1;
    }

    @JvmStatic
    public static final void d(@NotNull Context context, @NotNull Intent fromIntent, @NotNull MediaPickerOutput mediaPickerOutput) {
        ArrayList arrayList;
        List<LocalMediaInfo> f16;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        int mapCapacity2;
        String templateJsAsset;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fromIntent, "fromIntent");
        Intrinsics.checkNotNullParameter(mediaPickerOutput, "mediaPickerOutput");
        w53.b.f("WinkMediaPickerNavigator", "[jumpToEditor] enter");
        Intent intent = new Intent();
        Bundle extras = fromIntent.getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        Serializable serializableExtra = fromIntent.getSerializableExtra("key_attrs");
        HashMap hashMap = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
        if (hashMap != null && hashMap.containsKey(QCircleScheme.AttrQQPublish.FROM_ENTRANCE)) {
            intent.putExtra(QCircleScheme.AttrQQPublish.FROM_ENTRANCE, (String) hashMap.get(QCircleScheme.AttrQQPublish.FROM_ENTRANCE));
        }
        intent.putExtra(QQWinkConstants.IS_AUTO_TEMPLATE, mediaPickerOutput.getVideoTemplateData().getUseVideoTemplate());
        if (mediaPickerOutput.getVideoTemplateData().getUseVideoTemplate()) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null && true == extras2.containsKey("key_attrs")) {
                Serializable serializableExtra2 = fromIntent.getSerializableExtra("key_attrs");
                HashMap hashMap2 = serializableExtra2 instanceof HashMap ? (HashMap) serializableExtra2 : null;
                if (hashMap2 != null) {
                    HashMap hashMap3 = new HashMap(hashMap2);
                    if (hashMap3.containsKey("template")) {
                        hashMap3.remove("template");
                    }
                    intent.putExtra("key_attrs", hashMap3);
                }
            }
        }
        intent.putExtra(QQWinkConstants.IS_EDIT_TEXT, false);
        intent.putExtra(QQWinkConstants.IS_IMAGE_MODEL, false);
        List<LocalMediaInfo> f17 = mediaPickerOutput.f();
        if (f17 != null) {
            List<LocalMediaInfo> list = f17;
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault4);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(i.b((LocalMediaInfo) it.next()));
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                HashMap<String, Serializable> hashMap4 = ((LocalMediaInfo) it5.next()).extData;
                if (hashMap4 != null) {
                    hashMap4.clear();
                }
            }
        }
        intent.putExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL, new ArrayList(arrayList));
        List<LocalMediaInfo> e16 = mediaPickerOutput.e();
        if (e16 != null && (e16.isEmpty() ^ true)) {
            if (!uq3.c.r() && intent.hasExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL)) {
                Serializable serializableExtra3 = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
                Intrinsics.checkNotNull(serializableExtra3, "null cannot be cast to non-null type camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial");
                String i26 = WinkEditorResourceManager.a1().i2((MetaMaterial) serializableExtra3);
                if (!TextUtils.isEmpty(i26)) {
                    intent.putExtra("local_template_path", i26);
                }
            }
            f16 = mediaPickerOutput.e();
        } else {
            f16 = mediaPickerOutput.f();
        }
        if (intent.getBooleanExtra(QQWinkConstants.NEED_AUTO_FILL_TEMPLATE_LIBRARY_HOLDERS, false)) {
            f16 = f324860a.a(f16, intent);
        }
        if (uq3.c.r() && intent.hasExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL)) {
            Serializable serializableExtra4 = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
            Intrinsics.checkNotNull(serializableExtra4, "null cannot be cast to non-null type camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial");
            String i27 = WinkEditorResourceManager.a1().i2((MetaMaterial) serializableExtra4);
            if (!TextUtils.isEmpty(i27)) {
                intent.putExtra("local_template_path", i27);
            }
        }
        List<LocalMediaInfo> list2 = f16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList<LocalMediaInfo> arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it6 = list2.iterator();
        while (it6.hasNext()) {
            arrayList2.add(i.b((LocalMediaInfo) it6.next()));
        }
        for (LocalMediaInfo localMediaInfo : arrayList2) {
            HashMap<String, Serializable> hashMap5 = localMediaInfo.extData;
            if (hashMap5 != null) {
                hashMap5.remove("extDownloadUrl");
            }
            HashMap<String, Serializable> hashMap6 = localMediaInfo.extData;
            if (hashMap6 != null) {
                hashMap6.remove("extThunbUrl");
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : arrayList2) {
            linkedHashMap.put(((LocalMediaInfo) obj).path, obj);
        }
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), ((LocalMediaInfo) entry.getValue()).extData);
        }
        intent.putExtra(QQWinkConstants.LOCAL_MEDIA_INFO_EXT_DATA, new HashMap(linkedHashMap2));
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            ((LocalMediaInfo) it7.next()).extData = null;
        }
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(arrayList2));
        intent.putExtra(QQWinkConstants.EDITOR_ENTRANCE, 0);
        intent.putExtra(QQWinkConstants.IS_FROM_CAPTURE, false);
        List<QQCircleSmartMatchMusic$MusicInfo> c16 = mediaPickerOutput.c();
        if (c16 != null) {
            List<QQCircleSmartMatchMusic$MusicInfo> list3 = c16;
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
            Iterator<T> it8 = list3.iterator();
            while (it8.hasNext()) {
                arrayList3.add(((QQCircleSmartMatchMusic$MusicInfo) it8.next()).toByteArray());
            }
            intent.putExtra(QQWinkConstants.RECOMMEND_MUSIC_INFO_BYTES, new ArrayList(arrayList3));
        }
        List<QQCircleSmartMatchMusic$MusicStuckPointInfo> d16 = mediaPickerOutput.d();
        if (d16 != null && (d16.isEmpty() ^ true)) {
            intent.putExtra(QQWinkConstants.RECOMMEND_MUSIC_HAS_STUCK_POINT_INFO, true);
            com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a.i(mediaPickerOutput.d());
        } else {
            intent.putExtra(QQWinkConstants.RECOMMEND_MUSIC_HAS_STUCK_POINT_INFO, false);
        }
        intent.putExtra(QQWinkConstants.RECOMMEND_VIDEO_TEMPLATE_PRELOAD, mediaPickerOutput.getVideoTemplateData().getIsVideoTemplatePreLoad());
        if (fromIntent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE) != MediaPickerScene.TEMPLATE_ZSHOW && (templateJsAsset = mediaPickerOutput.getVideoTemplateData().getTemplateJsAsset()) != null) {
            intent.putExtra("key_template_asset", templateJsAsset);
        }
        Serializable serializableExtra5 = fromIntent.getSerializableExtra("key_attrs");
        HashMap hashMap7 = serializableExtra5 instanceof HashMap ? (HashMap) serializableExtra5 : null;
        if (hashMap7 != null) {
            String str = (String) hashMap7.get("music");
            if (str != null) {
                intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_ID, str);
            }
            String it9 = (String) hashMap7.get(QCircleScheme.AttrQQPublish.MUSIC_SCENE);
            if (it9 != null) {
                try {
                    Intrinsics.checkNotNullExpressionValue(it9, "it");
                    Intrinsics.checkNotNullExpressionValue(intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_SCENE, Integer.parseInt(it9)), "{\n                    to\u2026oInt())\n                }");
                } catch (NumberFormatException e17) {
                    w53.b.c("jumpToEditor", e17.toString());
                    Unit unit = Unit.INSTANCE;
                }
            }
            String str2 = (String) hashMap7.get(QCircleScheme.AttrQQPublish.MUSIC_AUTHOR_UID);
            if (str2 != null) {
                intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_AUTHOR_UID, str2);
            }
            String str3 = (String) hashMap7.get(QCircleScheme.AttrQQPublish.ENTER_FEED_ID);
            if (str3 != null) {
                intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_ENTER_FEED_ID, str3);
            }
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, 0);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, 10);
            activity.overridePendingTransition(0, 0);
        } else {
            context.startActivity(intent);
        }
        w53.b.f("WinkMediaPickerNavigator", "[jumpToEditor] exit");
    }

    public final void e(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        context.startActivity(WinkImageTemplateMediaPickerFragment.INSTANCE.a(context, bundle));
    }

    public final void f(@NotNull Context context, int requestCode, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", QCircleMakeStickerMediaPickerFragment.class.getName());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    public final void g(@NotNull Context context, @NotNull Intent fromIntent, @NotNull List<? extends LocalMediaInfo> selectedMedia) {
        LocalMediaInfo localMediaInfo;
        int collectionSizeOrDefault;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fromIntent, "fromIntent");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        Intent intent = new Intent();
        Bundle extras = fromIntent.getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        HashMap<String, LocalMediaInfo> hashMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : selectedMedia) {
            if (i.G((LocalMediaInfo) obj)) {
                arrayList2.add(obj);
            }
        }
        boolean z17 = false;
        if (arrayList2.size() == selectedMedia.size()) {
            List<? extends LocalMediaInfo> list = selectedMedia;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(((LocalMediaInfo) it.next()).path);
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                String str = (String) obj2;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    arrayList4.add(obj2);
                }
            }
            arrayList.addAll(arrayList4);
            b(o.f326724a.i(arrayList), hashMap);
        } else {
            ListIterator<? extends LocalMediaInfo> listIterator = selectedMedia.listIterator(selectedMedia.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    localMediaInfo = listIterator.previous();
                    LocalMediaInfo localMediaInfo2 = localMediaInfo;
                    if (i.G(localMediaInfo2) | i.I(localMediaInfo2)) {
                        break;
                    }
                } else {
                    localMediaInfo = null;
                    break;
                }
            }
            LocalMediaInfo localMediaInfo3 = localMediaInfo;
            if (localMediaInfo3 != null) {
                String str2 = localMediaInfo3.path;
                if (str2 == null || str2.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    arrayList.add(localMediaInfo3.path);
                }
            }
            b(o.f326724a.i(arrayList), hashMap);
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        z93.b e16 = Wink.INSTANCE.e();
        if (e16 != null) {
            e16.a(context, intent);
        }
    }

    public final void h(@NotNull Context context, int requestCode, @NotNull String traceId, @NotNull Config config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", UniversalMediaPickerFragment.class.getName());
        intent.putExtras(UniversalMediaPickerFragment.Companion.b(UniversalMediaPickerFragment.INSTANCE, config, null, 2, null));
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }
}
