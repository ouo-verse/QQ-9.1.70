package com.tencent.mobileqq.guild.client.selectaccount;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqguildsdk.data.db;
import com.tencent.mobileqq.qqguildsdk.data.dd;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/dd;", "areaList", "", "invoke", "(Lcom/tencent/mobileqq/qqguildsdk/data/dd;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildClientSelectListDialogFragment$loadData$1 extends Lambda implements Function1<dd, Unit> {
    final /* synthetic */ GuildClientSelectListDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildClientSelectListDialogFragment$loadData$1(GuildClientSelectListDialogFragment guildClientSelectListDialogFragment) {
        super(1);
        this.this$0 = guildClientSelectListDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildClientSelectListDialogFragment this$0, dd areaList) {
        PlainListAdapter plainListAdapter;
        PlainListAdapter plainListAdapter2;
        PlainListAdapter plainListAdapter3;
        PlainListAdapter plainListAdapter4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(areaList, "$areaList");
        plainListAdapter = this$0.mAdapter;
        PlainListAdapter plainListAdapter5 = null;
        if (plainListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter = null;
        }
        int size = plainListAdapter.getData().size();
        plainListAdapter2 = this$0.mAdapter;
        if (plainListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter2 = null;
        }
        plainListAdapter2.p0(areaList.getIsEnd());
        this$0.mCookie = areaList.getCookie();
        ArrayList<db> a16 = areaList.a();
        Intrinsics.checkNotNullExpressionValue(a16, "areaList.areas");
        this$0.Ch(a16);
        plainListAdapter3 = this$0.mAdapter;
        if (plainListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            plainListAdapter3 = null;
        }
        plainListAdapter3.r0(false);
        plainListAdapter4 = this$0.mAdapter;
        if (plainListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            plainListAdapter5 = plainListAdapter4;
        }
        plainListAdapter5.notifyItemRangeInserted(size, areaList.a().size());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(dd ddVar) {
        invoke2(ddVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final dd areaList) {
        Intrinsics.checkNotNullParameter(areaList, "areaList");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GuildClientSelectListDialogFragment guildClientSelectListDialogFragment = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.client.selectaccount.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildClientSelectListDialogFragment$loadData$1.b(GuildClientSelectListDialogFragment.this, areaList);
            }
        });
    }
}
