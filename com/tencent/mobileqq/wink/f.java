package com.tencent.mobileqq.wink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quiprofile.AIAvatarProfileThemeActivity;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailFragment;
import com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarMainFragment;
import com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultFragment;
import com.tencent.mobileqq.wink.api.IFSQQBaseService;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IWinkAIApi;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleCollectionPickerFragment;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibMainFragment;
import com.tencent.mobileqq.wink.templatelibrary.meme.WinkMemeDetailFragment;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkNewAlbumPreviewFragment;
import com.tencent.mobileqq.winkreport.datong.WinkSchemeConstant;
import cooperation.peak.PeakConstants;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Function2<Integer, Float, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f322852d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f322853e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f322854f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f322855h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f322856i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.api.b f322857m;

        a(ArrayList arrayList, Bundle bundle, Intent intent, long j3, Context context, com.tencent.mobileqq.wink.api.b bVar) {
            this.f322852d = arrayList;
            this.f322853e = bundle;
            this.f322854f = intent;
            this.f322855h = j3;
            this.f322856i = context;
            this.f322857m = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num, Float f16) {
            if (f16.floatValue() == 1.0f) {
                for (int i3 = 0; i3 < this.f322852d.size(); i3++) {
                    ((LocalMediaInfo) this.f322852d.get(i3)).path = MediaCompressUtils.f325262a.r().get(((LocalMediaInfo) this.f322852d.get(i3)).path);
                }
                this.f322853e.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, this.f322852d);
                this.f322854f.putExtras(this.f322853e);
                w53.b.a("QQWinkLauncher", "cost1time = " + (System.currentTimeMillis() - this.f322855h));
                Context context = this.f322856i;
                if (context instanceof Activity) {
                    if (((Activity) context).isFinishing()) {
                        w53.b.a("QQWinkLauncher", "activity already finish ,do not jump ");
                        return null;
                    }
                    ((Activity) this.f322856i).startActivityForResult(this.f322854f, 700);
                } else {
                    this.f322854f.addFlags(268435456);
                    this.f322856i.startActivity(this.f322854f.addFlags(268435456));
                }
                this.f322857m.a(true);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f322858a;

        static {
            int[] iArr = new int[IQQWinkLaucher.WinkHomePageType.values().length];
            f322858a = iArr;
            try {
                iArr[IQQWinkLaucher.WinkHomePageType.TYPE_COLLECTION_PICKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f322858a[IQQWinkLaucher.WinkHomePageType.TYPE_UNIVERSAL_PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void A(Activity activity, Bundle bundle, int i3) {
        w53.b.c("QQWinkLauncher", "[jumpToWinkPeaker]");
        Intent intent = new Intent();
        intent.setClass(activity, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", UniversalMediaPickerFragment.class.getName());
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        if (!f(intent)) {
            return;
        }
        activity.startActivityForResult(intent, i3);
    }

    public static void B(@NonNull Context context, @NonNull Bundle bundle) {
        if (TextUtils.isEmpty(bundle.getString(QQWinkConstants.MISSION_ID))) {
            w53.b.c("QQWinkLauncher", "jumpToWinkPreview missinID is null");
            v(context, bundle);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkPreviewFragment.class.getName());
        if (!f(intent)) {
            return;
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Context context) {
        QQToast.makeText(context, R.string.ylw, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(Context context) {
        QQToast.makeText(context, R.string.f238797kq, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Context context) {
        QQToast.makeText(context, R.string.f238797kq, 0).show();
    }

    public static void F(Context context, String str, Intent intent, int i3) {
        if (context == null) {
            w53.b.f("QQWinkLauncher", "launchFSHybirdActivity context == null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            w53.b.f("QQWinkLauncher", "launchFSHybirdActivity url isEmpty");
            return;
        }
        w53.b.f("QQWinkLauncher", "launchFSHybirdActivity url:" + str);
        if (!g(str)) {
            w53.b.f("QQWinkLauncher", "launchFSHybirdActivity url is Invalid");
            return;
        }
        if (FastClickUtils.isFastDoubleClick("launchFSHybirdActivity:" + str, 1500L)) {
            w53.b.f("QQWinkLauncher", "launchFSHybirdActivity is fast double click");
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        Intent handleFSPublishHybirdActivityIntent = ((IFSQQBaseService) QRoute.api(IFSQQBaseService.class)).handleFSPublishHybirdActivityIntent(context, str, intent, i3);
        handleFSPublishHybirdActivityIntent.putExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE, 3);
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).startActivityForResult(handleFSPublishHybirdActivityIntent, i3);
        } else {
            context.startActivity(handleFSPublishHybirdActivityIntent);
        }
    }

    private static ArrayList<LocalMediaInfo> d(HashMap<String, String> hashMap, boolean z16) {
        LocalMediaInfo c16;
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>();
        for (String str : hashMap.get("mediapath").split(",")) {
            if (str.contains(".mp4")) {
                c16 = ba3.a.d(str);
            } else {
                c16 = ba3.a.c(str);
                if (z16) {
                    c16._id = -1L;
                }
            }
            arrayList.add(c16);
        }
        return arrayList;
    }

    private static ArrayList<TemplateLibraryHolderInfo> e(HashMap<String, String> hashMap) {
        ArrayList<LocalMediaInfo> d16 = d(hashMap, true);
        ArrayList<TemplateLibraryHolderInfo> arrayList = new ArrayList<>();
        Iterator<LocalMediaInfo> it = d16.iterator();
        while (it.hasNext()) {
            arrayList.add(new TemplateLibraryHolderInfo(it.next(), -1.0f, ""));
        }
        return arrayList;
    }

    public static boolean f(Intent intent) {
        if (intent == null) {
            w53.b.c("QQWinkLauncher", "[jumpToTemplateFeed] invalid intent");
            return false;
        }
        if (!intent.hasExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) {
            w53.b.c("QQWinkLauncher", "[jumpToTemplateFeed] intent has no traceId");
            return false;
        }
        return true;
    }

    private static boolean g(String str) {
        try {
            URI uri = new URI(str);
            String host = uri.getHost();
            w53.b.a("QQWinkLauncher", "url:" + str + " domain:" + host);
            if (TextUtils.isEmpty(host) || !host.endsWith(QQWinkConstants.VALID_HOST)) {
                return false;
            }
            if (!uri.getScheme().equals("https")) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static Boolean h(@NonNull Intent intent, @NonNull Context context, @NonNull Bundle bundle, com.tencent.mobileqq.wink.api.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<? extends Parcelable> parcelableArrayList = bundle.getParcelableArrayList(QQWinkConstants.INPUT_MEDIA);
        if (parcelableArrayList != null && bVar != null && parcelableArrayList.size() == 1) {
            MediaCompressUtils mediaCompressUtils = MediaCompressUtils.f325262a;
            if (mediaCompressUtils.w(parcelableArrayList)) {
                w53.b.f("QQWinkLauncher", "compress: needCompressMedia");
                if (mediaCompressUtils.o().contains(((LocalMediaInfo) parcelableArrayList.get(0)).path)) {
                    w53.b.f("QQWinkLauncher", "compress: compressing media do not compress agin");
                    return Boolean.FALSE;
                }
                mediaCompressUtils.k(parcelableArrayList, new a(parcelableArrayList, bundle, intent, currentTimeMillis, context, bVar));
                return Boolean.FALSE;
            }
            w53.b.f("QQWinkLauncher", "compress: do not needCompressMedia");
            for (int i3 = 0; i3 < parcelableArrayList.size(); i3++) {
                String str = MediaCompressUtils.f325262a.r().get(((LocalMediaInfo) parcelableArrayList.get(i3)).path);
                if (!TextUtils.isEmpty(str)) {
                    w53.b.f("QQWinkLauncher", "compress: compressPath already exist");
                    ((LocalMediaInfo) parcelableArrayList.get(i3)).path = str;
                }
            }
            bundle.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, parcelableArrayList);
            intent.putExtras(bundle);
            w53.b.a("QQWinkLauncher", "cost time = " + (System.currentTimeMillis() - currentTimeMillis));
            return Boolean.TRUE;
        }
        w53.b.f("QQWinkLauncher", "compress: nothing need compress");
        return Boolean.TRUE;
    }

    private static boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106001", true);
    }

    private static int j(String str) {
        if (str != null) {
            if (str.startsWith("https://")) {
                return 0;
            }
            if (str.startsWith("mqqapi://")) {
                return 1;
            }
            return -1;
        }
        return -1;
    }

    public static String k(IQQWinkLaucher.WinkHomePageType winkHomePageType) {
        int i3 = b.f322858a[winkHomePageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return "";
            }
            return UniversalMediaPickerFragment.class.getName();
        }
        return QCircleCollectionPickerFragment.class.getName();
    }

    public static void l(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            w53.b.c("QQWinkLauncher", "url is empty");
            return;
        }
        w53.b.a("QQWinkLauncher", "handleUrl:" + str);
        int j3 = j(str);
        if (j3 == 0) {
            F(context, str, null, -1);
            return;
        }
        if (j3 == 1) {
            com.tencent.mobileqq.wink.b.d().enterByScheme(context, str);
            return;
        }
        w53.b.c("QQWinkLauncher", "invalid url: " + str);
    }

    public static void m(@NonNull Context context, @NonNull Bundle bundle) {
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, false);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, false);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, false);
        bundle.putString("AECAMERA_TAB_SELECTED", "9");
        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchAEMultiCamera(context, bundle);
    }

    public static void n(@NonNull Context context, @NonNull Bundle bundle) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkDynamicAvatarFragment.class.getName());
        if (!f(intent)) {
            return;
        }
        context.startActivity(intent);
    }

    public static void o(Context context, @NonNull String str, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, WinkContext.INSTANCE.d().businessConfig.a());
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkMemeDetailFragment.class.getName());
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
        }
        if (!f(intent)) {
            return;
        }
        context.startActivity(intent);
    }

    public static void p(final Context context, Intent intent) {
        boolean isFlashCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady();
        w53.b.f("QQWinkLauncher", "jumpToTemplateFeed: intent=" + intent + " videoSoUsable " + isFlashCameraResReady);
        if (!isFlashCameraResReady) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.C(context);
                }
            });
            return;
        }
        if (!f(intent)) {
            return;
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra("public_fragment_class", WinkQZoneTemplateLibMainFragment.class.getName());
        intent.putExtra("ARG_PADDING_BOTTOM", false);
        context.startActivity(intent);
    }

    public static void q(final Context context, Intent intent) {
        if (!((IWinkAIApi) QRoute.api(IWinkAIApi.class)).enableAIAvatar()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.D(context);
                }
            });
            return;
        }
        boolean z16 = context instanceof Activity;
        if (!z16) {
            intent.setFlags(268435456);
        }
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "AI_AVATAR");
        if (z16) {
            AIAvatarProfileThemeActivity.INSTANCE.b((Activity) context, intent, WinkAIAvatarMainFragment.class, 100);
        } else {
            AIAvatarProfileThemeActivity.INSTANCE.a(context, intent, WinkAIAvatarMainFragment.class);
        }
    }

    public static void r(Context context, Intent intent, View[] viewArr) {
        boolean z16 = context instanceof Activity;
        if (!z16) {
            intent.setFlags(268435456);
        }
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "AI_AVATAR");
        if (viewArr != null && z16) {
            if (i()) {
                intent.setClass(context, AIAvatarProfileThemeActivity.class);
                intent.putExtra("public_fragment_class", WinkAIAvatarMaterialDetailFragment.class.getName());
                Pair[] pairArr = new Pair[viewArr.length];
                for (int i3 = 0; i3 < viewArr.length; i3++) {
                    View view = viewArr[i3];
                    pairArr[i3] = new Pair(view, view.getTransitionName());
                }
                Activity activity = (Activity) context;
                activity.startActivityForResult(intent, 100, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairArr).toBundle());
                return;
            }
            AIAvatarProfileThemeActivity.INSTANCE.b((Activity) context, intent, WinkAIAvatarMaterialDetailFragment.class, 100);
            return;
        }
        AIAvatarProfileThemeActivity.INSTANCE.a(context, intent, WinkAIAvatarMaterialDetailFragment.class);
    }

    public static void s(Context context, Intent intent) {
        t(context, intent, null, null);
    }

    public static void t(final Context context, Intent intent, ArrayList<LocalMediaInfo> arrayList, ArrayList<LocalMediaInfo> arrayList2) {
        if (!((IWinkAIApi) QRoute.api(IWinkAIApi.class)).enableAIAvatar()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.E(context);
                }
            });
            return;
        }
        if (context != null && intent != null) {
            boolean z16 = context instanceof Activity;
            if (!z16) {
                intent.setFlags(268435456);
            }
            if (arrayList != null) {
                intent.putExtra("selected_local_media_info_list", arrayList);
            }
            if (arrayList2 != null) {
                intent.putExtra("selected_origin_local_media_info_list", arrayList2);
            }
            intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "AI_AVATAR");
            if (z16) {
                AIAvatarProfileThemeActivity.INSTANCE.b((Activity) context, intent, WinkAIAvatarResultFragment.class, 100);
                return;
            } else {
                AIAvatarProfileThemeActivity.INSTANCE.a(context, intent, WinkAIAvatarResultFragment.class);
                return;
            }
        }
        w53.b.c("QQWinkLauncher", "jumpToWinkAIAvatarResultFragment: context or intent is null");
    }

    public static void u(Context context, Intent intent, String str) {
        boolean z16;
        w53.b.f("QQWinkLauncher", "jumpToWinkEditor: intent=" + intent);
        if (!f(intent)) {
            return;
        }
        HashMap hashMap = (HashMap) intent.getSerializableExtra("key_attrs");
        if (hashMap != null && hashMap.containsKey(WinkSchemeConstant.SchemeKey.KEY_SCHEMA_FIRST_TEMPLATE)) {
            intent.putExtra(WinkSchemeConstant.SchemeKey.KEY_SCHEMA_FIRST_TEMPLATE, (String) hashMap.get(WinkSchemeConstant.SchemeKey.KEY_SCHEMA_FIRST_TEMPLATE));
        }
        intent.putExtra(QQWinkConstants.IS_AUTO_TEMPLATE, false);
        intent.putExtra(QQWinkConstants.IS_EDIT_TEXT, false);
        intent.putExtra(QQWinkConstants.IS_IMAGE_MODEL, false);
        if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get("pick_template_media_holder_count"))) {
            intent.putExtra("template_holder_slot", e(hashMap));
            intent.putExtra("pick_template_media_holder_count", (String) hashMap.get("pick_template_media_holder_count"));
            z16 = true;
        } else {
            z16 = false;
        }
        if (intent.getSerializableExtra(QQWinkConstants.INPUT_MEDIA) == null) {
            if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get("mediapath"))) {
                intent.putExtra(QQWinkConstants.INPUT_MEDIA, d(hashMap, z16));
            } else {
                w53.b.c("QQWinkLauncher", "jumpToWinkEditor... no path");
                return;
            }
        }
        intent.putExtra(QQWinkConstants.EDITOR_ENTRANCE, 0);
        intent.putExtra(QQWinkConstants.IS_FROM_CAPTURE, false);
        if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get("music"))) {
            intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_ID, (String) hashMap.get("music"));
        }
        if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get(QCircleScheme.AttrQQPublish.MUSIC_SCENE))) {
            try {
                intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_SCENE, Integer.parseInt((String) hashMap.get(QCircleScheme.AttrQQPublish.MUSIC_SCENE)));
            } catch (NumberFormatException e16) {
                w53.b.c("QQWinkLauncher", e16.toString());
            }
        }
        if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get(QCircleScheme.AttrQQPublish.MUSIC_AUTHOR_UID))) {
            intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_AUTHOR_UID, (String) hashMap.get(QCircleScheme.AttrQQPublish.MUSIC_AUTHOR_UID));
        }
        if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get("local_template_path"))) {
            intent.putExtra("local_template_path", (String) hashMap.get("local_template_path"));
        }
        if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get("key_template_asset"))) {
            intent.putExtra("key_template_asset", (String) hashMap.get("key_template_asset"));
        }
        if (hashMap != null && !TextUtils.isEmpty((CharSequence) hashMap.get("lib_template_id"))) {
            intent.putExtra("lib_template_id", (String) hashMap.get("lib_template_id"));
        }
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        context.startActivity(intent);
    }

    public static void v(Context context, @NonNull Bundle bundle) {
        if (context == null) {
            w53.b.f("QQWinkLauncher", "jumpToWinkEditor: context is null");
            return;
        }
        w53.b.f("QQWinkLauncher", "jumpToWinkEditor: bundle=" + bundle);
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        if (f(intent) && (context instanceof Activity)) {
            ((Activity) context).startActivityForResult(intent, 700);
        }
    }

    public static void w(@NonNull Fragment fragment, @NonNull Bundle bundle) {
        w53.b.f("QQWinkLauncher", "jumpToWinkEditorForResult: bundle=" + bundle);
        if (FastClickUtils.isFastDoubleClick("jumpToWinkEditorForResult")) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(fragment.getContext(), QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        if (!f(intent)) {
            return;
        }
        fragment.startActivityForResult(intent, 700);
    }

    public static void x(@NonNull Context context, @NonNull Bundle bundle, com.tencent.mobileqq.wink.api.b bVar) {
        w53.b.f("QQWinkLauncher", "jumpToWinkEditorWithCompressMedia: bundle=" + bundle);
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        if (!f(intent)) {
            return;
        }
        Boolean h16 = h(intent, context, bundle, bVar);
        w53.b.f("QQWinkLauncher", "jumpToWinkEditorWithCompressMedia " + h16);
        if (h16.booleanValue()) {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 700);
            } else {
                intent.addFlags(268435456);
                context.startActivity(intent.addFlags(268435456));
            }
            if (bVar != null) {
                bVar.a(true);
            }
            MediaCompressUtils.f325262a.o().clear();
        }
    }

    public static void y(Context context, Intent intent) {
        if (!f(intent)) {
            return;
        }
        MemoryAlbumPreviewFragment.INSTANCE.b(context, intent);
    }

    public static void z(Context context, Bundle bundle, ArrayList<LocalMediaInfo> arrayList) {
        w53.b.c("QQWinkLauncher", "[jumpToWinkNewAlbumPreview]");
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkNewAlbumPreviewFragment.class.getName());
        intent.putParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA, arrayList);
        if (!f(intent)) {
            return;
        }
        context.startActivity(intent);
    }
}
