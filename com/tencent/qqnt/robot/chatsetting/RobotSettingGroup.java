package com.tencent.qqnt.robot.chatsetting;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.newsetting.custom.config.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqnt.robot.chatsetting.RobotSettingGroup$mChatTimbreConfig$2;
import com.tencent.qqnt.robot.chatsetting.RobotSettingGroup$mResetChatConfig$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u000b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005H\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/robot/chatsetting/RobotSettingGroup;", "Lcom/tencent/mobileqq/activity/newsetting/custom/group/a;", "Lcom/tencent/qqnt/robot/chatsetting/a;", "Lcom/tencent/mobileqq/widget/listitem/Group;", "c", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "l", "Lcom/tencent/mobileqq/widget/listitem/x$c$c;", "o", "com/tencent/qqnt/robot/chatsetting/RobotSettingGroup$mChatTimbreConfig$2$a", "e", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/robot/chatsetting/RobotSettingGroup$mChatTimbreConfig$2$a;", "mChatTimbreConfig", "com/tencent/qqnt/robot/chatsetting/RobotSettingGroup$mResetChatConfig$2$a", "f", DomainData.DOMAIN_NAME, "()Lcom/tencent/qqnt/robot/chatsetting/RobotSettingGroup$mResetChatConfig$2$a;", "mResetChatConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RobotSettingGroup extends com.tencent.mobileqq.activity.newsetting.custom.group.a implements a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy mChatTimbreConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mResetChatConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingGroup(Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RobotSettingGroup$mChatTimbreConfig$2.a>() { // from class: com.tencent.qqnt.robot.chatsetting.RobotSettingGroup$mChatTimbreConfig$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/robot/chatsetting/RobotSettingGroup$mChatTimbreConfig$2$a", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a extends b<x.b.d, x.c.g> {
                a(x.b.d dVar, x.c.g gVar, QUIListItemAdapter qUIListItemAdapter) {
                    super(dVar, gVar, qUIListItemAdapter);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                String g16;
                QUIListItemAdapter f16;
                g16 = RobotSettingGroup.this.g(R.string.cz4);
                Intrinsics.checkNotNullExpressionValue(g16, "getString(R.string.preference1_title2)");
                x.b.d dVar = new x.b.d(g16);
                x.c.g gVar = new x.c.g("", false, false, 6, null);
                f16 = RobotSettingGroup.this.f();
                return new a(dVar, gVar, f16);
            }
        });
        this.mChatTimbreConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RobotSettingGroup$mResetChatConfig$2.a>() { // from class: com.tencent.qqnt.robot.chatsetting.RobotSettingGroup$mResetChatConfig$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/robot/chatsetting/RobotSettingGroup$mResetChatConfig$2$a", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$c;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a extends b<x.b.d, x.c.C8997c> {
                a(x.b.d dVar, x.c.C8997c c8997c, QUIListItemAdapter qUIListItemAdapter) {
                    super(dVar, c8997c, qUIListItemAdapter);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                String g16;
                QUIListItemAdapter f16;
                g16 = RobotSettingGroup.this.g(R.string.f221216a8);
                Intrinsics.checkNotNullExpressionValue(g16, "getString(R.string.reset_chat)");
                x.b.d dVar = new x.b.d(g16);
                x.c.C8997c c8997c = x.c.C8997c.f317072b;
                f16 = RobotSettingGroup.this.f();
                return new a(dVar, c8997c, f16);
            }
        });
        this.mResetChatConfig = lazy2;
    }

    private final RobotSettingGroup$mChatTimbreConfig$2.a m() {
        return (RobotSettingGroup$mChatTimbreConfig$2.a) this.mChatTimbreConfig.getValue();
    }

    private final RobotSettingGroup$mResetChatConfig$2.a n() {
        return (RobotSettingGroup$mResetChatConfig$2.a) this.mResetChatConfig.getValue();
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    protected Group c() {
        return new Group(m(), n());
    }

    @Override // com.tencent.qqnt.robot.chatsetting.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b<x.b.d, x.c.g> b() {
        return m();
    }

    @Override // com.tencent.qqnt.robot.chatsetting.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b<x.b.d, x.c.C8997c> a() {
        return n();
    }
}
