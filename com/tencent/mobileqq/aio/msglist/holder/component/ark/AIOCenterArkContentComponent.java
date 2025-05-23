package com.tencent.mobileqq.aio.msglist.holder.component.ark;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.shop.api.IShopAIOApi;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/AIOCenterArkContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/AIOArkContentComponent;", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "", ExifInterface.LATITUDE_SOUTH, "", "X1", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOCenterArkContentComponent extends AIOArkContentComponent {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOCenterArkContentComponent(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        if (!d.W(q1().getMsgRecord())) {
            return false;
        }
        return ((IShopAIOApi) a.INSTANCE.a(IShopAIOApi.class)).getQQShopIs2Tab();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ark.AIOArkContentComponent
    protected int X1() {
        return (a.C7329a.f192417a.d() - a81.d.f25684b) - a81.d.f25685c;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.ark.AIOArkContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        Integer num;
        boolean z16 = false;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new h(getMContext(), q1(), this), new u(getMContext(), q1(), this));
        ArkAppConfig arkAppConfig = getArkAppConfig();
        if (arkAppConfig != null && (num = arkAppConfig.forward) != null && num.intValue() == 1) {
            z16 = true;
        }
        if (z16) {
            mutableListOf.add(new u(getMContext(), q1(), this));
        }
        return mutableListOf;
    }
}
