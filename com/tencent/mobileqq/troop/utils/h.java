package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JF\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0016JD\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016Jb\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042(\b\u0002\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016JR\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042(\b\u0002\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016JR\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042(\b\u0002\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/h;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "pageId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "ignorePageInOutEvent", "", "b", "Landroid/view/View;", "view", "elementId", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "logicParent", "a", "params", "e", "c", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static void a(@NotNull h hVar, @NotNull View view, @NotNull String elementId, @Nullable HashMap<String, Object> hashMap, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @Nullable View view2) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
            Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
            if (view2 != null) {
                VideoReport.setLogicParent(view, view2);
            }
            VideoReport.setElementId(view, elementId);
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementClickPolicy(view, clickPolicy);
        }

        public static /* synthetic */ void b(h hVar, View view, String str, HashMap hashMap, ExposurePolicy exposurePolicy, ClickPolicy clickPolicy, View view2, int i3, Object obj) {
            HashMap hashMap2;
            ExposurePolicy exposurePolicy2;
            ClickPolicy clickPolicy2;
            View view3;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    hashMap2 = null;
                } else {
                    hashMap2 = hashMap;
                }
                if ((i3 & 8) != 0) {
                    exposurePolicy2 = ExposurePolicy.REPORT_ALL;
                } else {
                    exposurePolicy2 = exposurePolicy;
                }
                if ((i3 & 16) != 0) {
                    clickPolicy2 = ClickPolicy.REPORT_ALL;
                } else {
                    clickPolicy2 = clickPolicy;
                }
                if ((i3 & 32) != 0) {
                    view3 = null;
                } else {
                    view3 = view2;
                }
                hVar.e(view, str, hashMap2, exposurePolicy2, clickPolicy2, view3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElement");
        }

        public static void c(@NotNull h hVar, @NotNull Activity activity, @NotNull String pageId, @NotNull HashMap<String, Object> pageParams, boolean z16) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(pageParams, "pageParams");
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(activity.getWindow().getDecorView(), pageId);
            VideoReport.setPageParams(activity.getWindow().getDecorView(), new PageParams(pageParams));
            VideoReport.ignorePageInOutEvent(activity.getWindow().getDecorView(), z16);
        }

        public static /* synthetic */ void d(h hVar, Activity activity, String str, HashMap hashMap, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                hVar.b(activity, str, hashMap, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initPage");
        }

        public static void e(@NotNull h hVar, @NotNull View view, @Nullable String str, @Nullable HashMap<String, Object> hashMap, @Nullable View view2) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (str != null) {
                VideoReport.setElementId(view, str);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            }
            if (view2 != null) {
                VideoReport.setLogicParent(view, view2);
            }
            VideoReport.reportEvent("dt_clck", view, hashMap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void f(h hVar, View view, String str, HashMap hashMap, View view2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    hashMap = null;
                }
                if ((i3 & 8) != 0) {
                    view2 = null;
                }
                hVar.d(view, str, hashMap, view2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
        }

        public static void g(@NotNull h hVar, @Nullable View view, @NotNull String eventId, @NotNull HashMap<String, Object> params) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(params, "params");
            VideoReport.reportEvent(eventId, view, params);
        }

        public static void h(@NotNull h hVar, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            VideoReport.reportEvent("dt_imp", view, null);
        }

        public static void i(@NotNull h hVar, @NotNull View view, @Nullable String str, @Nullable HashMap<String, Object> hashMap, @Nullable View view2) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (str != null) {
                VideoReport.setElementId(view, str);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            }
            if (view2 != null) {
                VideoReport.setLogicParent(view, view2);
            }
            VideoReport.reportEvent("dt_imp", view, hashMap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void j(h hVar, View view, String str, HashMap hashMap, View view2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    hashMap = null;
                }
                if ((i3 & 8) != 0) {
                    view2 = null;
                }
                hVar.c(view, str, hashMap, view2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportExposure");
        }

        public static void k(@NotNull h hVar, @Nullable View view, @NotNull String pageId, boolean z16, @NotNull HashMap<String, Object> pageParams) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(pageParams, "pageParams");
            if (view == null) {
                return;
            }
            VideoReport.setPageId(view, pageId);
            VideoReport.setPageParams(view, new PageParams(pageParams));
            VideoReport.ignorePageInOutEvent(view, true);
            if (z16) {
                VideoReport.reportPgIn(view);
            } else {
                VideoReport.reportPgOut(view);
            }
        }

        public static void l(@NotNull h hVar, @NotNull View view, @NotNull String elementId, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @Nullable IDynamicParams iDynamicParams, @Nullable View view2) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
            Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
            if (view2 != null) {
                VideoReport.setLogicParent(view, view2);
            }
            VideoReport.setElementId(view, elementId);
            if (iDynamicParams != null) {
                VideoReport.setEventDynamicParams(view, iDynamicParams);
            }
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementClickPolicy(view, clickPolicy);
        }

        public static /* synthetic */ void m(h hVar, View view, String str, ExposurePolicy exposurePolicy, ClickPolicy clickPolicy, IDynamicParams iDynamicParams, View view2, int i3, Object obj) {
            IDynamicParams iDynamicParams2;
            View view3;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    exposurePolicy = ExposurePolicy.REPORT_ALL;
                }
                ExposurePolicy exposurePolicy2 = exposurePolicy;
                if ((i3 & 8) != 0) {
                    clickPolicy = ClickPolicy.REPORT_ALL;
                }
                ClickPolicy clickPolicy2 = clickPolicy;
                if ((i3 & 16) != 0) {
                    iDynamicParams2 = null;
                } else {
                    iDynamicParams2 = iDynamicParams;
                }
                if ((i3 & 32) != 0) {
                    view3 = null;
                } else {
                    view3 = view2;
                }
                hVar.a(view, str, exposurePolicy2, clickPolicy2, iDynamicParams2, view3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setElement");
        }
    }

    void a(@NotNull View view, @NotNull String elementId, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @Nullable IDynamicParams dynamicParams, @Nullable View logicParent);

    void b(@NotNull Activity activity, @NotNull String pageId, @NotNull HashMap<String, Object> pageParams, boolean ignorePageInOutEvent);

    void c(@NotNull View view, @Nullable String elementId, @Nullable HashMap<String, Object> params, @Nullable View logicParent);

    void d(@NotNull View view, @Nullable String elementId, @Nullable HashMap<String, Object> params, @Nullable View logicParent);

    void e(@NotNull View view, @NotNull String elementId, @Nullable HashMap<String, Object> params, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @Nullable View logicParent);
}
