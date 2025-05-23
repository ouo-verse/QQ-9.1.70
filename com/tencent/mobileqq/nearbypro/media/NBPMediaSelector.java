package com.tencent.mobileqq.nearbypro.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.util.LocalMediaInfoGenerator;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import i01.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J;\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000e\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\rJI\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122+\u0010\u000e\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\rJC\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162+\u0010\u000e\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\rJ\u0014\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\bR?\u0010\u001e\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/media/NBPMediaSelector;", "", "Landroid/content/Context;", "context", "", h.F, "c", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/nearbypro/media/a;", "Lkotlin/ParameterName;", "name", "medias", "Lcom/tencent/mobileqq/nearbypro/media/onSelectedResultCallback;", "callback", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lmqq/util/WeakReference;", "Li01/e;", "kuiklyModule", "e", "", "filePath", "g", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfoList", "d", "b", "Lkotlin/jvm/functions/Function1;", "selectorResultCallback", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPMediaSelector {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NBPMediaSelector f253605a = new NBPMediaSelector();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super List<NBPMediaInfo>, Unit> selectorResultCallback;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/nearbypro/media/NBPMediaSelector$a", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<e> f253607d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f253608e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<List<NBPMediaInfo>, Unit> f253609f;

        /* JADX WARN: Multi-variable type inference failed */
        a(WeakReference<e> weakReference, Activity activity, Function1<? super List<NBPMediaInfo>, Unit> function1) {
            this.f253607d = weakReference;
            this.f253608e = activity;
            this.f253609f = function1;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            String[] stringArrayExtra;
            Object firstOrNull;
            c.a.a(this, requestCode, resultCode, data);
            if (requestCode == 1000) {
                if (data != null && (stringArrayExtra = data.getStringArrayExtra("PhotoConst.PHOTO_PATHS")) != null) {
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(stringArrayExtra);
                    String str = (String) firstOrNull;
                    if (str != null) {
                        NBPMediaSelector.f253605a.g(this.f253608e, str, this.f253609f);
                    }
                }
                e eVar = this.f253607d.get();
                if (eVar != null) {
                    eVar.removeKuiklyRenderLifeCycleCallback(this);
                }
            }
        }
    }

    NBPMediaSelector() {
    }

    public final void c() {
        selectorResultCallback = null;
    }

    public final void d(@NotNull final List<? extends LocalMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.media.NBPMediaSelector$dealSelectedMediaList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1 function1;
                int collectionSizeOrDefault;
                function1 = NBPMediaSelector.selectorResultCallback;
                if (function1 != null) {
                    List<LocalMediaInfo> list = mediaInfoList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        String str = ((LocalMediaInfo) it.next()).path;
                        Intrinsics.checkNotNullExpressionValue(str, "it.path");
                        arrayList.add(new NBPMediaInfo(str));
                    }
                    function1.invoke(arrayList);
                }
                NBPMediaSelector.selectorResultCallback = null;
            }
        });
    }

    public final void e(@NotNull Activity activity, @NotNull WeakReference<e> kuiklyModule, @NotNull Function1<? super List<NBPMediaInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(kuiklyModule, "kuiklyModule");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a(kuiklyModule, activity, callback);
        e eVar = kuiklyModule.get();
        if (eVar != null) {
            eVar.addKuiklyRenderLifecycleCallback(aVar);
        }
        String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.PATH_NEARBY_PEOPLE_PHOTO) + System.currentTimeMillis() + ".jpg";
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", 100);
        intent.putExtra("BUSINESS_ORIGIN_NEW", 100);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 6);
        intent.putExtra("AVATAR_TO_CIRCLE_PUBLISH_ALBUM", true);
        String str2 = NewPhotoListActivity.AIO_PAD_ADAPT_STORY;
        intent.setClass(activity, NewPhotoListActivity.class);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 50);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, Reflection.getOrCreateKotlinClass(NBPPhotoListCustomization.class).getQualifiedName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        intent.putExtra(PeakConstants.TARGET_PATH, str);
        intent.putExtra(PeakConstants.CLIP_WIDTH, 640);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, 640);
        intent.putExtra(PeakConstants.TARGET_WIDTH, 640);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, 640);
        intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        activity.startActivityForResult(intent, 1000);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }

    public final void f(@NotNull Context context, @NotNull Function1<? super List<NBPMediaInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        selectorResultCallback = callback;
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "qqnearby");
        bundle.putLong("wink_output_point", 24L);
        bundle.putString("wink_output_route", NBPWinkOutputRouter.ROUTE_PATH);
        bundle.putString("app_key", "0AND05J90ZOPH3DU");
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_MUSIC, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
        bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(context, bundle);
    }

    public final void g(@NotNull Context context, @NotNull final String filePath, @NotNull final Function1<? super List<NBPMediaInfo>, Unit> callback) {
        List listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.media.NBPMediaSelector$openImageEditor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List<NBPMediaInfo> listOf2;
                    Function1<List<NBPMediaInfo>, Unit> function1 = callback;
                    listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new NBPMediaInfo(filePath));
                    function1.invoke(listOf2);
                }
            });
            return;
        }
        selectorResultCallback = callback;
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "qqnearby");
        bundle.putLong("wink_output_point", 35L);
        bundle.putString("wink_output_route", NBPWinkOutputRouter.ROUTE_PATH);
        bundle.putString("app_key", "0AND05J90ZOPH3DU");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(filePath);
        bundle.putSerializable(QQWinkConstants.INPUT_MEDIA, LocalMediaInfoGenerator.buildLocalMediaInfos(listOf));
        bundle.putBoolean(QQWinkConstants.IS_AUTO_TEMPLATE, false);
        bundle.putBoolean(QQWinkConstants.IS_IMAGE_MODEL, true);
        bundle.putBoolean(QQWinkConstants.IS_EDIT_TEXT, false);
        bundle.putBoolean(QQWinkConstants.IS_FROM_CAPTURE, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_MUSIC, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putString(QQWinkConstants.EDITOR_NEXT_BUTTON_TEXT, "\u5b8c\u6210");
        bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
        bundle.putInt("edit_image_mode", 1);
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditor(context, bundle);
    }

    public final void h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).preloadQQWink(context);
    }
}
