package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0002J\u001a\u0010!\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010$\u001a\u00020\bJ\u0016\u0010%\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u0016\u0010'\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppMoreUiSection;", "", "miniAppMoreRootView", "Landroid/view/View;", "moduleType", "", "moreClickListener", "Lkotlin/Function1;", "", "(Landroid/view/View;ILkotlin/jvm/functions/Function1;)V", "mAppStoreInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "mModuleArrow", "Landroid/widget/ImageView;", "mRvTitleDivider", "mRvTitleMoreLl", "Landroid/widget/LinearLayout;", "mRvTitleMoreTv", "Landroid/widget/TextView;", "mRvTitleOutterView", "mRvTitleTv", "getModuleType", "()I", "getMoreClickListener", "()Lkotlin/jvm/functions/Function1;", "bindView", "titleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "dataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "reportExposure", "miniAppInfo", "reportExposureAsync", "reportMoreClick", "reportMoreExposure", "setTitleGoneWhenDragging", "setTitleVisibleWhenDragStar", "dataSize", "setTitleVisibleWhenDragging", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppMoreUiSection {
    private static final String TAG = "MiniAppDesktopPart.MiniAppMoreUiSection";
    private MiniAppInfo mAppStoreInfo;
    private ImageView mModuleArrow;
    private View mRvTitleDivider;
    private LinearLayout mRvTitleMoreLl;
    private TextView mRvTitleMoreTv;
    private View mRvTitleOutterView;
    private TextView mRvTitleTv;
    private final View miniAppMoreRootView;
    private final int moduleType;
    private final Function1<Integer, Unit> moreClickListener;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniAppMoreUiSection(View miniAppMoreRootView, int i3, Function1<? super Integer, Unit> moreClickListener) {
        Intrinsics.checkNotNullParameter(miniAppMoreRootView, "miniAppMoreRootView");
        Intrinsics.checkNotNullParameter(moreClickListener, "moreClickListener");
        this.miniAppMoreRootView = miniAppMoreRootView;
        this.moduleType = i3;
        this.moreClickListener = moreClickListener;
        View findViewById = miniAppMoreRootView.findViewById(R.id.rkx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "miniAppMoreRootView.find\u2026R.id.recent_title_layout)");
        this.mRvTitleOutterView = findViewById;
        View findViewById2 = miniAppMoreRootView.findViewById(R.id.rgt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "miniAppMoreRootView.find\u2026id.mini_app_module_title)");
        this.mRvTitleTv = (TextView) findViewById2;
        View findViewById3 = miniAppMoreRootView.findViewById(R.id.rgv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "miniAppMoreRootView.find\u2026.id.mini_app_more_layout)");
        this.mRvTitleMoreLl = (LinearLayout) findViewById3;
        View findViewById4 = miniAppMoreRootView.findViewById(R.id.rgw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "miniAppMoreRootView.find\u2026(R.id.mini_app_more_text)");
        this.mRvTitleMoreTv = (TextView) findViewById4;
        View findViewById5 = miniAppMoreRootView.findViewById(R.id.rgu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "miniAppMoreRootView.find\u2026(R.id.mini_app_more_icon)");
        this.mModuleArrow = (ImageView) findViewById5;
        this.mRvTitleDivider = miniAppMoreRootView.findViewById(R.id.rgs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(MiniAppMoreUiSection this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mRvTitleMoreLl.getVisibility() != 0) {
            QLog.d(TAG, 1, " mRvTitleMoreLl is gone,not response click!");
            return;
        }
        int i3 = this$0.moduleType;
        if (i3 != 1 && i3 != 3) {
            MiniAppUtils.reportMiniGameCenterDC00087("1", "969", "9044", "904401", "209626", "20", EntryConstants.DropdownEntry.DROPDOWN_FRIEND_PLAYING_ENTRY);
            Context context = this$0.miniAppMoreRootView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            MiniAppLauncher.launchMiniGameCenter((Activity) context, EntryConstants.DropdownEntry.DROPDOWN_FRIEND_PLAYING_ENTRY);
            return;
        }
        this$0.moreClickListener.invoke(Integer.valueOf(i3));
        this$0.reportMoreClick(this$0.moduleType);
    }

    private final void reportExposure(int moduleType, MiniAppInfo miniAppInfo) {
        boolean startsWith$default;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        LaunchParam launchParam = miniAppConfig.launchParam;
        launchParam.scene = 3004;
        if (moduleType == 1) {
            launchParam.scene = 3005;
        } else if (moduleType == 3) {
            launchParam.scene = 3041;
        }
        String appId = miniAppInfo.appId;
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(appId, "v", false, 2, null);
        if (startsWith$default) {
            return;
        }
        MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo");
        MiniAppInfo miniAppInfo2 = this.mAppStoreInfo;
        String str = miniAppInfo2 != null ? miniAppInfo2.appId : null;
        Integer valueOf = miniAppInfo2 != null ? Integer.valueOf(miniAppInfo2.verType) : null;
        String str2 = str + "_" + valueOf + "_" + moduleType + "_" + miniAppConfig.launchParam.scene;
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
        ((MiniAppExposureManager) manager).putReportDataToMap(str2, miniAppModuleExposureData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportExposureAsync$lambda$1(MiniAppMoreUiSection this$0, int i3, MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.reportExposure(i3, miniAppInfo);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "MiniAppMoreUiSection, mModuleType:" + this$0.moduleType + ", reportExposureAsync failed.", e16);
        }
    }

    private final void reportMoreClick(final int moduleType) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppMoreUiSection.reportMoreClick$lambda$3(moduleType);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportMoreClick$lambda$3(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, " reportMoreClick " + i3);
        }
        if (i3 == 1) {
            MiniProgramLpReportDC04239.reportMiniAppEvent(null, "0", null, "page_view", "em_click", MiniProgramLpReportDC04239.MINI_LATELY_MORE_ICON, null);
        } else {
            if (i3 != 3) {
                return;
            }
            MiniProgramLpReportDC04239.reportMiniAppEvent(null, "0", null, "page_view", "em_click", MiniProgramLpReportDC04239.MINI_MYMINIAPP_MORE_ICON, null);
        }
    }

    private final void reportMoreExposure(final int moduleType) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, " reportMoreExposure " + moduleType);
        }
        if (this.mRvTitleMoreLl.getVisibility() == 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.a
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppMoreUiSection.reportMoreExposure$lambda$2(moduleType);
                }
            }, 16, null, true);
        }
    }

    public final void bindView(DesktopAppModuleInfo titleInfo, List<DesktopItemInfo> dataList) {
        int color;
        Intrinsics.checkNotNullParameter(titleInfo, "titleInfo");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.mRvTitleTv.setText(titleInfo.moduleTitle.toString());
        int i3 = this.moduleType;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            this.mRvTitleMoreLl.setVisibility(8);
        } else {
            MiniAppInfo miniAppInfo = titleInfo.appStoreInfo;
            if (miniAppInfo != null) {
                this.mAppStoreInfo = miniAppInfo;
                reportExposureAsync(i3, miniAppInfo);
            }
            this.mRvTitleMoreLl.setVisibility(0);
            reportMoreExposure(this.moduleType);
            com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
            UIUtils.c(this.mRvTitleMoreLl, cVar.b(10), 0, cVar.b(30), 0);
            this.mRvTitleMoreLl.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAppMoreUiSection.bindView$lambda$0(MiniAppMoreUiSection.this, view);
                }
            });
        }
        int i16 = this.moduleType;
        if (i16 == 1) {
            View view = this.mRvTitleDivider;
            if (view != null) {
                view.setVisibility(8);
            }
            if (dataList.size() > 8) {
                this.mRvTitleMoreLl.setVisibility(0);
            } else if (dataList.size() > 0) {
                this.mRvTitleMoreLl.setVisibility(8);
            } else {
                this.mRvTitleOutterView.setVisibility(8);
            }
        } else if (i16 != 2) {
            if (i16 == 3) {
                View view2 = this.mRvTitleDivider;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (dataList.size() > 4) {
                    this.mRvTitleOutterView.setVisibility(0);
                    this.mRvTitleMoreLl.setVisibility(0);
                } else if (dataList.size() > 0) {
                    this.mRvTitleOutterView.setVisibility(0);
                    this.mRvTitleMoreLl.setVisibility(8);
                } else {
                    this.mRvTitleOutterView.setVisibility(8);
                }
            }
        } else if (dataList.size() > 0) {
            View view3 = this.mRvTitleDivider;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.mRvTitleMoreLl.setVisibility(0);
            View view4 = this.mRvTitleDivider;
            if (view4 != null) {
                if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                    color = this.miniAppMoreRootView.getContext().getColor(R.color.f157962cr4);
                } else {
                    color = this.miniAppMoreRootView.getContext().getColor(R.color.skin_color_ffe6e6e6);
                }
                view4.setBackgroundColor(color);
            }
        }
        this.mModuleArrow.clearColorFilter();
        this.mRvTitleTv.setTextColor(this.miniAppMoreRootView.getContext().getColor(R.color.qui_common_text_primary));
        this.mRvTitleMoreTv.setTextColor(this.miniAppMoreRootView.getContext().getColor(R.color.qui_common_text_primary));
    }

    public final int getModuleType() {
        return this.moduleType;
    }

    public final Function1<Integer, Unit> getMoreClickListener() {
        return this.moreClickListener;
    }

    public final void setTitleGoneWhenDragging() {
        this.mRvTitleOutterView.setVisibility(8);
        this.mRvTitleMoreLl.setVisibility(8);
    }

    private final void reportExposureAsync(final int moduleType, final MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppMoreUiSection.reportExposureAsync$lambda$1(MiniAppMoreUiSection.this, moduleType, miniAppInfo);
            }
        }, 64, null, false);
    }

    public final void setTitleVisibleWhenDragStar(int moduleType, int dataSize) {
        if (moduleType == 3) {
            if (dataSize > 4) {
                this.mRvTitleOutterView.setVisibility(0);
                this.mRvTitleMoreLl.setVisibility(0);
            } else if (dataSize >= 0) {
                this.mRvTitleOutterView.setVisibility(0);
                this.mRvTitleMoreLl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportMoreExposure$lambda$2(int i3) {
        if (i3 == 1) {
            MiniProgramLpReportDC04239.reportMiniAppEvent(null, "0", null, "page_view", "em_expo", MiniProgramLpReportDC04239.MINI_LATELY_MORE_ICON, null);
        } else {
            if (i3 != 3) {
                return;
            }
            MiniProgramLpReportDC04239.reportMiniAppEvent(null, "0", null, "page_view", "em_expo", MiniProgramLpReportDC04239.MINI_MYMINIAPP_MORE_ICON, null);
        }
    }

    public final void setTitleVisibleWhenDragging(int moduleType, int dataSize) {
        if (moduleType == 1) {
            if (dataSize > 8) {
                this.mRvTitleMoreLl.setVisibility(0);
                return;
            } else if (dataSize > 0) {
                this.mRvTitleMoreLl.setVisibility(8);
                return;
            } else {
                this.mRvTitleOutterView.setVisibility(8);
                return;
            }
        }
        if (moduleType != 3) {
            return;
        }
        if (dataSize > 4) {
            this.mRvTitleOutterView.setVisibility(0);
            this.mRvTitleMoreLl.setVisibility(0);
        } else if (dataSize > 0) {
            this.mRvTitleOutterView.setVisibility(0);
            this.mRvTitleMoreLl.setVisibility(8);
        } else {
            this.mRvTitleOutterView.setVisibility(8);
        }
    }
}
