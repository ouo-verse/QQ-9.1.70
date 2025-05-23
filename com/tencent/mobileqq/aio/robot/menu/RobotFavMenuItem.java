package com.tencent.mobileqq.aio.robot.menu;

import android.content.Context;
import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ui.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e*\u0014\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0005:\u0001\u001fB\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/robot/menu/RobotFavMenuItem;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Lcom/tencent/qqnt/aio/menu/ui/d;", "", "f", "", "c", "", h.F, "b", "e", "Landroid/content/Context;", "d", "Landroid/content/Context;", "i", "()Landroid/content/Context;", "context", "Lcom/tencent/aio/base/mvvm/a;", "j", "()Lcom/tencent/aio/base/mvvm/a;", "vb", "Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/aio/base/mvvm/a;)V", "g", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotFavMenuItem<VB extends a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> extends d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VB vb;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotFavMenuItem(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        super(msgItem);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        this.context = context;
        this.vb = vb5;
        String string = context.getResources().getString(R.string.b3m);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.favorite)");
        this.title = string;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        return R.drawable.jwq;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        return R.id.c39;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        return "RobotFavMenuItem";
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.menu.ui.d
    public void h() {
        com.tencent.aio.api.runtime.a aVar;
        BaseVM mUIModel = this.vb.getMUIModel();
        if (mUIModel != null) {
            aVar = (com.tencent.aio.api.runtime.a) mUIModel.getSafetyContext();
        } else {
            aVar = null;
        }
        i81.a.a(aVar, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.robot.menu.RobotFavMenuItem$onClickMenu$1
            final /* synthetic */ RobotFavMenuItem<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                com.tencent.aio.api.runtime.a aVar2;
                j e16;
                FrameworkVM mUIModel2 = this.this$0.j().getMUIModel();
                if (mUIModel2 == null || (aVar2 = (com.tencent.aio.api.runtime.a) mUIModel2.getSafetyContext()) == null || (e16 = aVar2.e()) == null) {
                    return null;
                }
                AIOMsgItem msgItem = this.this$0.d();
                Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
                e16.h(new RobotMsgIntent.SingleMsgFav(msgItem));
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.robot.menu.RobotFavMenuItem$onClickMenu$2
            final /* synthetic */ RobotFavMenuItem<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IAIOFavApi iAIOFavApi = (IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class);
                Context context = this.this$0.getContext();
                AIOMsgItem msgItem = this.this$0.d();
                Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
                iAIOFavApi.addFav(context, msgItem, null);
            }
        });
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final VB j() {
        return this.vb;
    }
}
