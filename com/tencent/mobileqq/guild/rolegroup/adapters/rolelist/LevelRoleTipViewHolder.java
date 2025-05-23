package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fBI\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00128\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016RF\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/LevelRoleTipViewHolder;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "Lkotlin/Function0;", "", NodeProps.ON_CLICK, "Landroid/text/style/ClickableSpan;", "o", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "l", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "v", "E", "Lkotlin/jvm/functions/Function2;", "itemClickCallback", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "desc", "G", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LevelRoleTipViewHolder extends ad {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function2<r, View, Unit> itemClickCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView desc;

    /* renamed from: G, reason: from kotlin metadata */
    private r item;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/LevelRoleTipViewHolder$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.LevelRoleTipViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.ew7, parent, false);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/adapters/rolelist/LevelRoleTipViewHolder$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f232300d;

        b(Function0<Unit> function0) {
            this.f232300d = function0;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            this.f232300d.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(Color.parseColor("#0099FF"));
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LevelRoleTipViewHolder(@NotNull ViewGroup parent, @NotNull Function2<? super r, ? super View, Unit> itemClickCallback) {
        super(r2);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemClickCallback, "itemClickCallback");
        View b16 = INSTANCE.b(parent);
        Intrinsics.checkNotNullExpressionValue(b16, "inflateLayout(parent)");
        this.itemClickCallback = itemClickCallback;
        View findViewById = this.itemView.findViewById(R.id.wlc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.guild_level_desc)");
        this.desc = (TextView) findViewById;
    }

    private final ClickableSpan o(Function0<Unit> onClick) {
        return new b(onClick);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.ad
    public void l(@NotNull final r item, @NotNull RoleGroupListViewModel.ShowState state) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "state");
        if (item instanceof LevelRoleTipItem) {
            this.item = item;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.qqStr(R.string.f154781fq));
            ClickableSpan o16 = o(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.LevelRoleTipViewHolder$bindData$webViewJumpTextClickSpan$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Function2 function2;
                    TextView textView;
                    Logger.f235387a.d().d("GuildLevelRole.LevelRoleTipViewHolder", 1, "clickSpan webViewJumpTextClickSpan");
                    function2 = LevelRoleTipViewHolder.this.itemClickCallback;
                    r rVar = item;
                    textView = LevelRoleTipViewHolder.this.desc;
                    function2.invoke(rVar, textView);
                }
            });
            Drawable drawable = this.itemView.getResources().getDrawable(R.drawable.guild_assistant_list_item_arrow);
            drawable.setBounds(QQGuildUIUtil.e(2.0f, this.itemView.getResources()), QQGuildUIUtil.e(-1.0f, this.itemView.getResources()), QQGuildUIUtil.e(8.0f, this.itemView.getResources()), QQGuildUIUtil.e(9.0f, this.itemView.getResources()));
            VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable);
            String qqStr = HardCodeUtil.qqStr(R.string.f154761fo);
            spannableStringBuilder.append((CharSequence) (qqStr + " "));
            spannableStringBuilder.setSpan(verticalCenterImageSpan, spannableStringBuilder.length() + (-1), spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(o16, (spannableStringBuilder.length() - qqStr.length()) + (-1), spannableStringBuilder.length(), 17);
            this.desc.setText(spannableStringBuilder);
            this.desc.setMovementMethod(LinkMovementMethod.getInstance());
            this.desc.setHighlightColor(0);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
