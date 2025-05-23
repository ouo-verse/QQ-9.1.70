package com.tencent.mobileqq.wink.editor.aielimination;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Consumer;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.share.WinkShareUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/y;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "", "d", "", "sharingDitch", "c", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "Ljava/lang/String;", "sharePic", "Lcom/tencent/mobileqq/wink/api/c;", "f", "Lcom/tencent/mobileqq/wink/api/c;", "data", "Lcom/tencent/mobileqq/wink/editor/aielimination/a;", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/aielimination/a;", "shareModel", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/wink/api/c;)V", "i", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class y implements ShareActionSheet.OnItemClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sharePic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.api.c data;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a shareModel;

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
    
        if (r6 == true) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y(@NotNull Activity activity, @NotNull String sharePic, @NotNull com.tencent.mobileqq.wink.api.c data) {
        boolean z16;
        String str;
        boolean z17;
        String str2;
        boolean z18;
        String str3;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sharePic, "sharePic");
        Intrinsics.checkNotNullParameter(data, "data");
        this.activity = activity;
        this.sharePic = sharePic;
        this.data = data;
        a aVar = new a();
        String str4 = (String) data.f().get("shareH5ContentTitle");
        boolean z29 = true;
        if (str4 != null) {
            if (str4.length() > 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (z28) {
                z16 = true;
                if (z16) {
                    aVar.j(str4);
                }
                str = (String) data.f().get("shareH5ContentDesc");
                if (str != null) {
                    if (str.length() > 0) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    if (z27) {
                        z17 = true;
                        if (z17) {
                            aVar.h(str);
                        }
                        str2 = (String) data.f().get("shareH5ContentOutsideDesc");
                        if (str2 != null) {
                            if (str2.length() > 0) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                z18 = true;
                                if (z18) {
                                    aVar.g(str2);
                                }
                                str3 = (String) data.f().get("shareH5ContentPreviewImg");
                                if (str3 != null) {
                                    if (str3.length() > 0) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                }
                                z29 = false;
                                if (z29) {
                                    aVar.i(str3);
                                }
                                this.shareModel = aVar;
                            }
                        }
                        z18 = false;
                        if (z18) {
                        }
                        str3 = (String) data.f().get("shareH5ContentPreviewImg");
                        if (str3 != null) {
                        }
                        z29 = false;
                        if (z29) {
                        }
                        this.shareModel = aVar;
                    }
                }
                z17 = false;
                if (z17) {
                }
                str2 = (String) data.f().get("shareH5ContentOutsideDesc");
                if (str2 != null) {
                }
                z18 = false;
                if (z18) {
                }
                str3 = (String) data.f().get("shareH5ContentPreviewImg");
                if (str3 != null) {
                }
                z29 = false;
                if (z29) {
                }
                this.shareModel = aVar;
            }
        }
        z16 = false;
        if (z16) {
        }
        str = (String) data.f().get("shareH5ContentDesc");
        if (str != null) {
        }
        z17 = false;
        if (z17) {
        }
        str2 = (String) data.f().get("shareH5ContentOutsideDesc");
        if (str2 != null) {
        }
        z18 = false;
        if (z18) {
        }
        str3 = (String) data.f().get("shareH5ContentPreviewImg");
        if (str3 != null) {
        }
        z29 = false;
        if (z29) {
        }
        this.shareModel = aVar;
    }

    private final void c(String sharingDitch) {
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_SHARE);
        map.put("qq_eid", WinkDaTongReportConstant.ElementId.EM_QZ_SHARE);
        map.putAll(this.data.e());
        map.put(WinkDaTongReportConstant.ElementParamKey.SHARING_DITCH, sharingDitch);
        VideoReport.reportEvent("qq_clck", map);
    }

    private final void d() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            Activity activity = this.activity;
            QQToast.makeText(activity, activity.getResources().getString(R.string.f185153nt), 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(ba3.a.c(this.sharePic));
        bundle.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, arrayList);
        bundle.putString(WinkDTParamBuilder.APP_KEY_NAME, "0AND0MWZXR4U3RVU");
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        WinkContext.Companion companion = WinkContext.INSTANCE;
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, companion.g());
        bundle.putInt(QQWinkConstants.EDITOR_ENTRANCE, 10);
        companion.o(companion.b(bundle));
        Intent intent = new Intent();
        intent.setClass(this.activity, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        this.activity.startActivityForResult(intent, 52133);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final y this$0, final RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.x
            @Override // java.lang.Runnable
            public final void run() {
                y.f(y.this, rFWSaveMediaResultBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(y this$0, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Boolean, Unit> c16 = this$0.data.c();
        if (c16 != null) {
            boolean z16 = false;
            if (rFWSaveMediaResultBean != null && rFWSaveMediaResultBean.isSuccess) {
                z16 = true;
            }
            c16.invoke(Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        WinkShareUtils winkShareUtils = new WinkShareUtils();
        winkShareUtils.n(this.data.a());
        int i3 = item.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 39) {
                                if (i3 == 203) {
                                    w53.b.f("WinkAIEliminationShareBehavior", "onItemClick to LITTLE_WORLD");
                                    d();
                                    c("4");
                                }
                            } else {
                                w53.b.f("WinkAIEliminationShareBehavior", "onItemClick to SAVE");
                                RFWSaveUtil.insertMedia(BaseApplication.context, this.sharePic, new Consumer() { // from class: com.tencent.mobileqq.wink.editor.aielimination.w
                                    @Override // androidx.core.util.Consumer
                                    public final void accept(Object obj) {
                                        y.e(y.this, (RFWSaveMediaResultBean) obj);
                                    }
                                });
                                c("0");
                            }
                        } else {
                            w53.b.f("WinkAIEliminationShareBehavior", "onItemClick to WECHAT_CIRCLE");
                            if (this.data.b()) {
                                winkShareUtils.v(this.activity, this.shareModel.getShareUrl(), this.shareModel.getTitle(), this.shareModel.getDesc(), this.shareModel.getPreview(), true);
                            } else {
                                winkShareUtils.B(this.activity, this.sharePic, true);
                            }
                            c("2");
                        }
                    } else {
                        w53.b.f("WinkAIEliminationShareBehavior", "onItemClick to WECHAT");
                        if (this.data.b()) {
                            WinkShareUtils.w(winkShareUtils, this.activity, this.shareModel.getShareUrl(), this.shareModel.getTitle(), this.shareModel.getDesc(), this.shareModel.getPreview(), false, 32, null);
                        } else {
                            winkShareUtils.B(this.activity, this.sharePic, false);
                        }
                        c("1");
                    }
                } else {
                    w53.b.f("WinkAIEliminationShareBehavior", "onItemClick to QZONE");
                    if (this.data.b()) {
                        winkShareUtils.C(this.activity, this.shareModel.getSchemaUrl(), this.shareModel.getTitle(), this.shareModel.getDescForQq(), this.shareModel.getPreview(), 52135);
                    } else {
                        winkShareUtils.A(this.activity, this.sharePic, 52134, this.data.d());
                    }
                    c("3");
                }
            } else {
                w53.b.f("WinkAIEliminationShareBehavior", "onItemClick to FRIEND");
                if (this.data.b()) {
                    WinkShareUtils.p(winkShareUtils, this.activity, "qzone_auto_removal", item.uinType, item.uin, this.shareModel.getShareUrl(), this.shareModel.getTitle(), this.shareModel.getDescForQq(), this.shareModel.getPreview(), 52133, 0, null, 1536, null);
                } else {
                    WinkShareUtils.y(winkShareUtils, this.activity, this.sharePic, null, 52133, false, 16, null);
                }
                c("5");
            }
        } else {
            w53.b.f("WinkAIEliminationShareBehavior", "onItemClick to COPYLINK");
            winkShareUtils.c(this.activity, this.shareModel.getShareUrl());
        }
        shareActionSheet.dismiss();
    }
}
