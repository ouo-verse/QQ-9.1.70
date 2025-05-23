package p54;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.api.IDirectMessageNode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.api.runtime.b;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.robot.slash.businessapi.ConvertSearchTools;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u0010/\u001a\u00020\u0004\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0001J\t\u0010\f\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J!\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0014\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010'\u001a\u0004\u0018\u00010&2\b\u0010%\u001a\u0004\u0018\u00010!2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013H\u0016R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010,R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010.\u00a8\u00062"}, d2 = {"Lp54/a;", "Lcom/tencent/robot/slash/businessapi/c;", "Lu54/c;", h.F, "Landroid/view/View;", "l", "", "hideKeyboard", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "f", "d", "c", "Lb54/a;", "itemArgs", "e", "g", "Lb74/a;", "itemData", "", "keyword", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "functionInfo", "", "functionType", "i", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "Lcom/tencent/robot/slash/businessapi/a;", "j", "robotUin", "robotTinyId", "b", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/view/View;", "mAnchorView", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ o54.a f425368c;

    public a(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
        this.f425368c = new o54.a(mAIOContext, mAnchorView);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        this.f425368c.a(itemData, keyword);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String robotUin, @NotNull String robotTinyId) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotTinyId, "robotTinyId");
        FragmentActivity activity = this.mAIOContext.c().getActivity();
        if (activity == null) {
            return;
        }
        AIOContact c16 = this.mAIOContext.g().r().c();
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openRobotProfileCard(activity, c16.f(), c16.j(), robotTinyId, "", "6", true);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        this.f425368c.c();
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.f425368c.d(rootView);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        this.f425368c.e(itemArgs);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.f425368c.f(rootView);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void g(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        this.f425368c.g(itemArgs);
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    public u54.c h() {
        return this.f425368c.h();
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public boolean hideKeyboard() {
        return this.f425368c.hideKeyboard();
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void i(@NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo functionInfo, int functionType) {
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(functionInfo, "functionInfo");
        this.f425368c.i(robotInfo, functionInfo, functionType);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public com.tencent.robot.slash.businessapi.a j(@Nullable Object searchResponse, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (searchResponse instanceof List) {
            ArrayList<b74.a> f16 = ConvertSearchTools.f368422a.f((List) searchResponse, keyword);
            CollectionsKt__MutableCollectionsKt.removeFirstOrNull(f16);
            return new com.tencent.robot.slash.businessapi.a(f16, null, 0, 4, null);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x002e, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchSessionParams k(@Nullable Object args) {
        Long longOrNull;
        ArrayList arrayListOf;
        AIOContact c16 = this.mAIOContext.g().r().c();
        String srcGuildId = ((IDirectMessageNode) QRoute.api(IDirectMessageNode.class)).getSrcGuildId(c16.j());
        String srcTinyId = ((IDirectMessageNode) QRoute.api(IDirectMessageNode.class)).getSrcTinyId(c16.j());
        if (srcTinyId != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            Contact contact = new Contact(c16.e(), c16.j(), srcGuildId);
            ArrayList arrayList = new ArrayList();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(longValue));
            return new SearchSessionParams(contact, arrayList, arrayListOf, CommonBotScene.KDM, CommonBotFilter.KEXCLUDEUNABLESPEAKBOT, String.valueOf(longValue));
        }
        return null;
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    /* renamed from: l */
    public View getMAnchorView() {
        return this.f425368c.getMAnchorView();
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @NotNull
    public n<u54.c> m(@NotNull b mviContext) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        return new k54.a(mviContext, this);
    }
}
