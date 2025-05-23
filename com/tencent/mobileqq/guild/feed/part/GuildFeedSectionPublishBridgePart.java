package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.view.View;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/GuildFeedSectionPublishBridgePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroidx/core/util/Supplier;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "d", "Landroidx/core/util/Supplier;", "getInitBean", "()Landroidx/core/util/Supplier;", "initBean", "Lxj1/b;", "e", "Lxj1/b;", "partIoc", "Lmp1/b;", "f", "Lkotlin/Lazy;", "getGuildHomeViewModel", "()Lmp1/b;", "guildHomeViewModel", "<init>", "(Landroidx/core/util/Supplier;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSectionPublishBridgePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<GuildFeedBaseInitBean> initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private xj1.b partIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildHomeViewModel;

    public GuildFeedSectionPublishBridgePart(@NotNull Supplier<GuildFeedBaseInitBean> initBean) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeViewModel>() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedSectionPublishBridgePart$guildHomeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildHomeViewModel invoke() {
                Object m476constructorimpl;
                Object partHost = GuildFeedSectionPublishBridgePart.this.getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                ViewModelStoreOwner b16 = com.tencent.mobileqq.guild.base.fragments.f.b((Fragment) partHost);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl((GuildHomeViewModel) new ViewModelProvider(b16).get(GuildHomeViewModel.class));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                GuildFeedSectionPublishBridgePart guildFeedSectionPublishBridgePart = GuildFeedSectionPublishBridgePart.this;
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger = Logger.f235387a;
                    String logTag = guildFeedSectionPublishBridgePart.getTAG();
                    Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
                    Logger.b bVar = new Logger.b();
                    String str = "initViewModel(GuildHomeViewModel) error:" + m479exceptionOrNullimpl.getMessage();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e(logTag, 1, (String) it.next(), null);
                    }
                    m476constructorimpl = null;
                }
                GuildFeedSectionPublishBridgePart guildFeedSectionPublishBridgePart2 = GuildFeedSectionPublishBridgePart.this;
                GuildHomeViewModel guildHomeViewModel = (GuildHomeViewModel) m476constructorimpl;
                Logger logger2 = Logger.f235387a;
                String logTag2 = guildFeedSectionPublishBridgePart2.getTAG();
                Intrinsics.checkNotNullExpressionValue(logTag2, "logTag");
                logger2.d().i(logTag2, 1, "initViewModel(GuildHomeViewModel) id:" + System.identityHashCode(guildHomeViewModel));
                return guildHomeViewModel;
            }
        });
        this.guildHomeViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable final View rootView) {
        super.onInitView(rootView);
        xj1.b bVar = (xj1.b) PartIOCKt.getIocInterface(this, xj1.b.class);
        if (bVar == null) {
            QLog.e(getTAG(), 1, "[onInitView]: partIoc is null");
            return;
        }
        this.partIoc = bVar;
        bVar.x8(this.initBean);
        LiveData<Integer> C2 = bVar.C2();
        LifecycleOwner c16 = a.c(this);
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedSectionPublishBridgePart$onInitView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                QLog.i(GuildFeedSectionPublishBridgePart.this.getTAG(), 1, "[onInitView]: updatePadding(bottom=" + it + ")");
                View view = rootView;
                if (view != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), it.intValue());
                }
            }
        };
        C2.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.part.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedSectionPublishBridgePart.z9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        SectionInfo sectionInfo;
        xj1.e eVar = (xj1.e) PartIOCKt.getIocInterface(this, xj1.e.class);
        if (eVar == null) {
            QLog.e(getTAG(), 1, "[onPartResume]: sectionInfoIoc is null");
            return;
        }
        com.tencent.mobileqq.guild.feed.feedsquare.data.l a16 = eVar.a();
        if (a16 == null) {
            QLog.e(getTAG(), 1, "[onPartResume]: sectionInfo is null");
        }
        String tag = getTAG();
        if (a16 != null) {
            sectionInfo = a16.getSectionInfo();
        } else {
            sectionInfo = null;
        }
        QLog.i(tag, 1, "[onPartResume]: sectionInfo=" + sectionInfo);
        xj1.b bVar = this.partIoc;
        if (bVar != null) {
            Intrinsics.checkNotNull(a16);
            bVar.O5(a16);
        }
    }
}
