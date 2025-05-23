package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPMainControlViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FeedEntranceTipsTask implements ISequenceTask {
    public final NBPMainControlViewModel controlVm;

    public FeedEntranceTipsTask(NBPMainControlViewModel nBPMainControlViewModel) {
        this.controlVm = nBPMainControlViewModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    public final boolean canStart() {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Utils.INSTANCE.cacheModule("").getItem("NBP_CACHE_KEY_HOME_LAST_PLAY_FEEDS_ENTRANCE_TIPS_TIME"));
        if (!NearbyFormatUtils.INSTANCE.isToday(longOrNull != null ? longOrNull.longValue() : 0L)) {
            return true;
        }
        KLog.INSTANCE.i("FeedEntranceTipsTask", "FeedsEntranceTips played today");
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    public final void onStart(final Function1<? super Boolean, Unit> function1) {
        TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.FeedEntranceTipsTask$onStart$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                KLog.INSTANCE.i("FeedEntranceTipsTask", "FeedsEntranceTips play");
                NBPMainControlViewModel nBPMainControlViewModel = FeedEntranceTipsTask.this.controlVm;
                nBPMainControlViewModel.showFeedsEntranceTips$delegate.setValue(nBPMainControlViewModel, NBPMainControlViewModel.$$delegatedProperties[2], Boolean.TRUE);
                final FeedEntranceTipsTask feedEntranceTipsTask = FeedEntranceTipsTask.this;
                final Function1<Boolean, Unit> function12 = function1;
                TimerKt.d(2330, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.FeedEntranceTipsTask$onStart$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NBPMainControlViewModel nBPMainControlViewModel2 = FeedEntranceTipsTask.this.controlVm;
                        ReadWriteProperty readWriteProperty = nBPMainControlViewModel2.showFeedsEntranceTips$delegate;
                        KProperty<?> kProperty = NBPMainControlViewModel.$$delegatedProperties[2];
                        Boolean bool = Boolean.FALSE;
                        readWriteProperty.setValue(nBPMainControlViewModel2, kProperty, bool);
                        Utils.INSTANCE.cacheModule("").setItem("NBP_CACHE_KEY_HOME_LAST_PLAY_FEEDS_ENTRANCE_TIPS_TIME", String.valueOf(APICallTechReporterKt.NBPCurrentTime()));
                        function12.invoke(bool);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }
}
