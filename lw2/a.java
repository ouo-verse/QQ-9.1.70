package lw2;

import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import com.tencent.qqlive.ona.protocol.jce.AdOpenAppItem;
import com.tencent.qqlive.ona.protocol.jce.AdOpenMiniProgramItem;
import com.tencent.tvideo.protocol.pb.AdAction;
import com.tencent.tvideo.protocol.pb.AdActionType;
import com.tencent.tvideo.protocol.pb.AdDownloadAction;
import com.tencent.tvideo.protocol.pb.AdOpenAppAction;
import com.tencent.tvideo.protocol.pb.AdOpenWxProgramAction;
import com.tencent.tvideo.protocol.pb.AdPageType;
import com.tencent.tvideo.protocol.pb.AdParseType;
import com.tencent.tvideo.protocol.pb.AdWebAction;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements lw2.g<AdAction, com.tencent.qqlive.ona.protocol.jce.AdAction> {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<AdActionType, i> f415692a;

    /* compiled from: P */
    /* renamed from: lw2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C10751a implements i {
        C10751a() {
        }

        @Override // lw2.a.i
        public int a() {
            return 0;
        }

        @Override // lw2.a.i
        public void b(AdActionItem adActionItem, AdAction adAction, boolean z16) {
            a.n(adActionItem, adAction, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements i {
        b() {
        }

        @Override // lw2.a.i
        public int a() {
            return 1;
        }

        @Override // lw2.a.i
        public void b(AdActionItem adActionItem, AdAction adAction, boolean z16) {
            a.i(adActionItem, adAction, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements i {
        c() {
        }

        @Override // lw2.a.i
        public int a() {
            return 3;
        }

        @Override // lw2.a.i
        public void b(AdActionItem adActionItem, AdAction adAction, boolean z16) {
            a.n(adActionItem, adAction, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements i {
        d() {
        }

        @Override // lw2.a.i
        public int a() {
            return 2;
        }

        @Override // lw2.a.i
        public void b(AdActionItem adActionItem, AdAction adAction, boolean z16) {
            a.j(adActionItem, adAction, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e implements i {
        e() {
        }

        @Override // lw2.a.i
        public int a() {
            return 4;
        }

        @Override // lw2.a.i
        public void b(AdActionItem adActionItem, AdAction adAction, boolean z16) {
            a.j(adActionItem, adAction, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class f implements i {
        f() {
        }

        @Override // lw2.a.i
        public int a() {
            return 104;
        }

        @Override // lw2.a.i
        public void b(AdActionItem adActionItem, AdAction adAction, boolean z16) {
            a.k(adActionItem, adAction, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g implements i {
        g() {
        }

        @Override // lw2.a.i
        public int a() {
            return 102;
        }

        @Override // lw2.a.i
        public void b(AdActionItem adActionItem, AdAction adAction, boolean z16) {
            a.k(adActionItem, adAction, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static /* synthetic */ class h {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f415693a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f415694b;

        static {
            int[] iArr = new int[AdParseType.values().length];
            f415694b = iArr;
            try {
                iArr[AdParseType.AD_PARSE_TYPE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f415694b[AdParseType.AD_PARSE_TYPE_NEED_PARSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[AdPageType.values().length];
            f415693a = iArr2;
            try {
                iArr2[AdPageType.AD_PAGE_TYPE_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f415693a[AdPageType.AD_PAGE_TYPE_SPLIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f415693a[AdPageType.AD_PAGE_TYPE_HALF_LANDING_PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface i {
        int a();

        void b(AdActionItem adActionItem, AdAction adAction, boolean z16);
    }

    static {
        HashMap<AdActionType, i> hashMap = new HashMap<>();
        f415692a = hashMap;
        hashMap.put(AdActionType.AD_ACTION_TYPE_OPEN_H5, new C10751a());
        f415692a.put(AdActionType.AD_ACTION_TYPE_DOWNLOAD, new b());
        f415692a.put(AdActionType.AD_ACTION_TYPE_OPEN_JDH5, new c());
        f415692a.put(AdActionType.AD_ACTION_TYPE_OPEN_APP, new d());
        f415692a.put(AdActionType.AD_ACTION_TYPE_DOUBLE_LINK_OPEN_APP, new e());
        f415692a.put(AdActionType.AD_ACTION_TYPE_OPEN_MINI_GAME, new f());
        f415692a.put(AdActionType.AD_ACTION_TYPE_OPEN_MINIPROGRAM, new g());
    }

    public static int g(AdActionType adActionType) {
        i iVar;
        if (adActionType == null || (iVar = f415692a.get(adActionType)) == null) {
            return 999;
        }
        return iVar.a();
    }

    public static void h(AdActionItem adActionItem, AdActionType adActionType, AdAction adAction, boolean z16) {
        i iVar = f415692a.get(adActionType);
        if (iVar != null) {
            iVar.b(adActionItem, adAction, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(AdActionItem adActionItem, AdAction adAction, boolean z16) {
        AdDownloadAction adDownloadAction;
        com.tencent.tvideo.protocol.pb.AdActionItem adActionItem2 = adAction.action_item;
        if (adActionItem2 == null || (adDownloadAction = adActionItem2.download_action) == null) {
            adDownloadAction = null;
        }
        if (adDownloadAction == null) {
            return;
        }
        adActionItem.adDownload = (AdDownloadItem) kw2.a.b().a(adDownloadAction);
        adActionItem.adH5UrlItem = (AdH5UrlItem) kw2.a.b().a(adDownloadAction.failed_web_action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(AdActionItem adActionItem, AdAction adAction, boolean z16) {
        AdOpenAppAction adOpenAppAction;
        com.tencent.tvideo.protocol.pb.AdActionItem adActionItem2 = adAction.action_item;
        if (adActionItem2 == null || (adOpenAppAction = adActionItem2.open_app_action) == null) {
            adOpenAppAction = null;
        }
        if (adOpenAppAction == null) {
            return;
        }
        adActionItem.adOpenApp = (AdOpenAppItem) kw2.a.b().a(adOpenAppAction);
        adActionItem.adH5UrlItem = (AdH5UrlItem) kw2.a.b().a(adOpenAppAction.failed_web_action);
        AdOpenWxProgramAction adOpenWxProgramAction = adOpenAppAction.failed_miniapp_action;
        adActionItem.adOpenMiniProgram = (AdOpenMiniProgramItem) kw2.a.b().a(adOpenWxProgramAction);
        adActionItem.adOpenMiniGame = (AdOpenMiniProgramItem) kw2.a.b().a(adOpenWxProgramAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(AdActionItem adActionItem, AdAction adAction, boolean z16) {
        AdOpenWxProgramAction adOpenWxProgramAction;
        com.tencent.tvideo.protocol.pb.AdActionItem adActionItem2 = adAction.action_item;
        if (adActionItem2 == null || (adOpenWxProgramAction = adActionItem2.open_mini_program) == null) {
            adOpenWxProgramAction = null;
        }
        if (adOpenWxProgramAction == null) {
            return;
        }
        adActionItem.adOpenMiniProgram = (AdOpenMiniProgramItem) kw2.a.b().a(adOpenWxProgramAction);
        adActionItem.adOpenMiniGame = (AdOpenMiniProgramItem) kw2.a.b().a(adOpenWxProgramAction);
        adActionItem.adH5UrlItem = (AdH5UrlItem) kw2.a.b().a(adOpenWxProgramAction.failed_web_action);
    }

    private int l(AdPageType adPageType) {
        if (adPageType == null) {
            return 0;
        }
        int i3 = h.f415693a[adPageType.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                return 0;
            }
            return 2;
        }
        return 1;
    }

    public static int m(AdParseType adParseType) {
        if (adParseType == null || h.f415694b[adParseType.ordinal()] != 2) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(AdActionItem adActionItem, AdAction adAction, boolean z16) {
        AdWebAction adWebAction;
        com.tencent.tvideo.protocol.pb.AdActionItem adActionItem2 = adAction.action_item;
        if (adActionItem2 == null || (adWebAction = adActionItem2.web_action) == null) {
            adWebAction = null;
        }
        if (adWebAction != null) {
            adActionItem.adH5UrlItem = (AdH5UrlItem) kw2.a.b().a(adWebAction);
        }
    }

    @Override // lw2.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqlive.ona.protocol.jce.AdAction a(AdAction adAction) {
        if (adAction == null) {
            return null;
        }
        com.tencent.qqlive.ona.protocol.jce.AdAction adAction2 = new com.tencent.qqlive.ona.protocol.jce.AdAction();
        adAction2.actionType = g(adAction.action_type);
        adAction2.pageType = l(adAction.page_type);
        AdActionItem adActionItem = new AdActionItem();
        adActionItem.parseType = m(adAction.parse_type);
        h(adActionItem, adAction.action_type, adAction, false);
        adAction2.actionItem = adActionItem;
        return adAction2;
    }
}
