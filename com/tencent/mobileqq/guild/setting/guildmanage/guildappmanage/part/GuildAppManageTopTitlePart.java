package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.event.GuildApplicationShowNumberEvent;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/GuildAppManageTopTitlePart;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/a;", "", "K9", "G9", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "e", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "J9", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "viewModel", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivBackIcon", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "tvTopOperate", "i", "ivAvatar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvGuildName", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAppManageTopTitlePart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildApplicationManageViewModel viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivBackIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvTopOperate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivAvatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvGuildName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAppManageTopTitlePart(@NotNull GuildApplicationManageViewModel viewModel) {
        super(viewModel);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    private final void G9() {
        if (getPartHost().getHostActivity() == null) {
            QLog.i("GuildAppManageTopTitlePart", 1, "click back activity == null");
            return;
        }
        Context hostContext = getPartHost().getHostContext();
        Integer value = getViewModel().f2().getValue();
        if (value != null && value.intValue() == 1 && getViewModel().getIsStartEdit()) {
            DialogUtil.createCustomDialog(hostContext, 230, (String) null, "\u9000\u51fa\u524d\u662f\u5426\u4fdd\u5b58\u672c\u6b21\u4fee\u6539\uff1f", hostContext.getString(R.string.f140850f3), hostContext.getString(R.string.h3s), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildAppManageTopTitlePart.H9(GuildAppManageTopTitlePart.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildAppManageTopTitlePart.I9(GuildAppManageTopTitlePart.this, dialogInterface, i3);
                }
            }).show();
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildApplicationShowNumberEvent(getViewModel().j2()));
        Activity hostActivity = getPartHost().getHostActivity();
        if (hostActivity != null) {
            hostActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(final GuildAppManageTopTitlePart this$0, final DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().s2(new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageTopTitlePart$clickBack$confirmDialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (!z16) {
                    QQToastUtil.showQQToast(0, "\u4fdd\u5b58\u5931\u8d25!");
                } else {
                    SimpleEventBus.getInstance().dispatchEvent(new GuildApplicationShowNumberEvent(GuildAppManageTopTitlePart.this.getViewModel().j2()));
                }
                dialogInterface.dismiss();
                Activity hostActivity = GuildAppManageTopTitlePart.this.getPartHost().getHostActivity();
                if (hostActivity != null) {
                    hostActivity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(GuildAppManageTopTitlePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        Activity hostActivity = this$0.getPartHost().getHostActivity();
        if (hostActivity != null) {
            hostActivity.finish();
        }
    }

    private final void K9() {
        TextView textView = this.tvTopOperate;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildAppManageTopTitlePart.L9(GuildAppManageTopTitlePart.this, view);
                }
            });
        }
        LiveData<Integer> f26 = getViewModel().f2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageTopTitlePart$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
            
                r2 = r1.this$0.tvTopOperate;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Integer num) {
                TextView textView2;
                TextView textView3;
                if (num != null && num.intValue() == 0) {
                    textView3 = GuildAppManageTopTitlePart.this.tvTopOperate;
                    if (textView3 == null) {
                        return;
                    }
                    textView3.setText("\u7ba1\u7406");
                    return;
                }
                if (num == null || num.intValue() != 1 || textView2 == null) {
                    return;
                }
                textView2.setText("\u5b8c\u6210");
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAppManageTopTitlePart.M9(Function1.this, obj);
            }
        });
        ImageView imageView = this.ivBackIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildAppManageTopTitlePart.N9(GuildAppManageTopTitlePart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(GuildAppManageTopTitlePart this$0, View view) {
        String str;
        Map map;
        String joinToString$default;
        String joinToString$default2;
        String joinToString$default3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.tvTopOperate;
        Integer value = this$0.getViewModel().f2().getValue();
        if (value != null && value.intValue() == 1) {
            str = "em_sgrp_complete_btn";
        } else {
            str = "em_sgrp_manage";
        }
        VideoReport.setElementId(textView, str);
        Integer value2 = this$0.getViewModel().f2().getValue();
        if (value2 != null && value2.intValue() == 1) {
            this$0.getViewModel().S1(0);
            this$0.getViewModel().s2(new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageTopTitlePart$initObserver$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                    invoke(bool.booleanValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    if (z16) {
                        return;
                    }
                    QQToastUtil.showQQToast(1, errMsg);
                }
            });
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this$0.getViewModel().h2(), ",", null, null, 0, null, null, 62, null);
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(this$0.getViewModel().i2(), ",", null, null, 0, null, null, 62, null);
            joinToString$default3 = CollectionsKt___CollectionsKt.joinToString$default(this$0.getViewModel().g2(), ",", null, null, 0, null, null, 62, null);
            map = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_apply_category_name", joinToString$default), TuplesKt.to("sgrp_navigation_url", joinToString$default2), TuplesKt.to("sgrp_apply_category_type", joinToString$default3));
        } else {
            this$0.getViewModel().S1(1);
            map = null;
        }
        VideoReport.reportEvent("clck", this$0.tvTopOperate, map);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(GuildAppManageTopTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        getViewModel().c2(new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageTopTitlePart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                ImageView imageView;
                TextView textView;
                if (iGProGuildInfo != null) {
                    GuildAppManageTopTitlePart guildAppManageTopTitlePart = GuildAppManageTopTitlePart.this;
                    imageView = guildAppManageTopTitlePart.ivAvatar;
                    if (imageView != null) {
                        String avatarUrl = iGProGuildInfo.getAvatarUrl(40);
                        Intrinsics.checkNotNullExpressionValue(avatarUrl, "getAvatarUrl(IGuiildAvatarUrlType.SIZE_40)");
                        v.i(avatarUrl, imageView);
                    }
                    textView = guildAppManageTopTitlePart.tvGuildName;
                    if (textView != null) {
                        textView.setText(iGProGuildInfo.getGuildName());
                    }
                }
            }
        });
    }

    @NotNull
    /* renamed from: J9, reason: from getter */
    public GuildApplicationManageViewModel getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        G9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        super.onInitView(rootView);
        TextView textView2 = null;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.du6);
        } else {
            imageView = null;
        }
        this.ivBackIcon = imageView;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f112076my);
        } else {
            textView = null;
        }
        this.tvTopOperate = textView;
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.f165909du3);
        } else {
            imageView2 = null;
        }
        this.ivAvatar = imageView2;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f108476d8);
        }
        this.tvGuildName = textView2;
        K9();
        initData();
        VideoReport.setElementExposePolicy(this.tvTopOperate, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.tvTopOperate, ClickPolicy.REPORT_NONE);
    }
}
