package com.tencent.mobileqq.zootopia.ue;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.helper.ZootopiaResidenceHelper;
import com.tencent.mobileqq.zootopia.lua.ZootopiaEnterAvatarScenePlugin;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001*\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016JZ\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u001628\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0016R\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u0016\u0010\u001d\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/ZootopiaResidenceModule;", "Lcom/tencent/mobileqq/zootopia/ue/a;", "Lcom/tencent/mobileqq/zootopia/lua/i;", "Lcom/tencent/mobileqq/zootopia/portal/detail/b;", "", "i", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "e", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/d;", DownloadInfo.spKey_Config, "u9", "destroy", "resume", "pause", "enterAvatarResidence", "", IZootopiaShareArkService.ARK_MAP_ID, "", "extras", "", FavEmoConstant.ROAMING_TYPE_PANEL, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "retCode", "serverCode", "callback", "a", "La94/c;", "f", "Lkotlin/Lazy;", "getFragmentStack", "()La94/c;", "fragmentStack", "Lcom/tencent/mobileqq/zootopia/helper/ZootopiaResidenceHelper;", tl.h.F, "j", "()Lcom/tencent/mobileqq/zootopia/helper/ZootopiaResidenceHelper;", "residenceHelper", "com/tencent/mobileqq/zootopia/ue/ZootopiaResidenceModule$b", "Lcom/tencent/mobileqq/zootopia/ue/ZootopiaResidenceModule$b;", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaResidenceModule extends a implements com.tencent.mobileqq.zootopia.lua.i, com.tencent.mobileqq.zootopia.portal.detail.b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy fragmentStack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy residenceHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zootopia/ue/ZootopiaResidenceModule$b", "Ls84/e;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements s84.e {
        b() {
        }

        @Override // s84.e
        public void a() {
            ZootopiaResidenceModule.this.i();
        }
    }

    public ZootopiaResidenceModule() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a94.c>() { // from class: com.tencent.mobileqq.zootopia.ue.ZootopiaResidenceModule$fragmentStack$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a94.c invoke() {
                return new a94.c(ZootopiaResidenceModule.this.c(), R.id.qz9);
            }
        });
        this.fragmentStack = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaResidenceHelper>() { // from class: com.tencent.mobileqq.zootopia.ue.ZootopiaResidenceModule$residenceHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaResidenceHelper invoke() {
                return new ZootopiaResidenceHelper(ZootopiaResidenceModule.this.c(), ZootopiaResidenceModule.this.d().getSourceCurrent(), ZootopiaResidenceModule.this);
            }
        });
        this.residenceHelper = lazy2;
        this.callback = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        JSONObject jSONObject = new JSONObject();
        w84.a aVar = w84.a.f445029a;
        jSONObject.put("Hide", aVar.e());
        jSONObject.put("reason", aVar.a());
        QLog.i("ZootopiaResidenceModule", 2, "HideResidence: " + jSONObject);
        ar.f328509a.a("N2L_HideResidence", jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.zootopia.lua.i
    public void a(int mapID, String extras, boolean needDownload, Function2<? super Integer, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        j().a(mapID, extras, needDownload, callback);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void destroy() {
        ZootopiaEnterAvatarScenePlugin.INSTANCE.a().h(this);
        s84.d.f433509a.f(this.callback);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a
    protected List<LuaBasePlugin> e() {
        List<LuaBasePlugin> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.mobileqq.zootopia.lua.i
    public void enterAvatarResidence() {
        j().b();
    }

    public final ZootopiaResidenceHelper j() {
        return (ZootopiaResidenceHelper) this.residenceHelper.getValue();
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void pause() {
        ZootopiaEnterAvatarScenePlugin.INSTANCE.a().h(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void resume() {
        ZootopiaEnterAvatarScenePlugin.INSTANCE.a().g(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void u9(FragmentActivity activity, d config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        super.u9(activity, config);
        ZootopiaEnterAvatarScenePlugin.INSTANCE.a().g(this);
        s84.d.f433509a.a(this.callback);
    }
}
