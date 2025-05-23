package com.tencent.biz.qqcircle.immersive.personal.part;

import android.view.View;
import androidx.core.util.Consumer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalGuildInfoEmptyEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0014\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/w;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/l;", "data", "z9", "Landroidx/core/util/Consumer;", "", "consumer", "B9", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "d", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "e", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "mAdapter", "f", "Landroidx/core/util/Consumer;", "mItemOnClickConsumer", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class w extends com.tencent.biz.qqcircle.immersive.part.u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUISettingsRecyclerView mRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIListItemAdapter mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Consumer<Long> mItemOnClickConsumer;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(com.tencent.biz.qqcircle.immersive.personal.bean.l guild2, w this$0, UIStateData data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(guild2, "$guild");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (guild2.c()) {
            Consumer<Long> consumer = this$0.mItemOnClickConsumer;
            if (consumer != null) {
                consumer.accept(0L);
            }
            guild2.f(false);
        } else {
            for (com.tencent.biz.qqcircle.immersive.personal.bean.l lVar : (List) data.getData()) {
                lVar.f(Intrinsics.areEqual(lVar, guild2));
            }
            Consumer<Long> consumer2 = this$0.mItemOnClickConsumer;
            if (consumer2 != null) {
                consumer2.accept(Long.valueOf(guild2.a()));
            }
        }
        this$0.z9(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void B9(@NotNull Consumer<Long> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.mItemOnClickConsumer = consumer;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f43421mf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_guild_binding_rv)");
        this.mRecyclerView = (QUISettingsRecyclerView) findViewById;
        this.mAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = this.mRecyclerView;
        QUIListItemAdapter qUIListItemAdapter = null;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            qUISettingsRecyclerView = null;
        }
        QUIListItemAdapter qUIListItemAdapter2 = this.mAdapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter2;
        }
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
    }

    public final void z9(@NotNull final UIStateData<List<com.tencent.biz.qqcircle.immersive.personal.bean.l>> data) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getData() != null && !data.getData().isEmpty()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalGuildInfoEmptyEvent(false));
            ArrayList arrayList = new ArrayList();
            for (final com.tencent.biz.qqcircle.immersive.personal.bean.l lVar : data.getData()) {
                if (lVar.a() != 0) {
                    String b16 = lVar.b();
                    Intrinsics.checkNotNullExpressionValue(b16, "guild.guildName");
                    x.b.d dVar = new x.b.d(b16);
                    if (lVar.c()) {
                        i3 = R.string.cancel;
                    } else {
                        i3 = R.string.f227686rp;
                    }
                    String a16 = com.tencent.biz.qqcircle.utils.h.a(i3);
                    Intrinsics.checkNotNullExpressionValue(a16, "if (guild.isIsSelect) Ha\u2026Util.qqStr(R.string.show)");
                    arrayList.add(new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.b(a16, new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.v
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            w.A9(com.tencent.biz.qqcircle.immersive.personal.bean.l.this, this, data, view);
                        }
                    }, false, null, 12, null)));
                }
            }
            QUIListItemAdapter qUIListItemAdapter = this.mAdapter;
            if (qUIListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                qUIListItemAdapter = null;
            }
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19271489);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_perso\u2026nd_only_one_channel_text)");
            Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
            qUIListItemAdapter.t0(new Group(a17, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalGuildInfoEmptyEvent(true));
    }
}
