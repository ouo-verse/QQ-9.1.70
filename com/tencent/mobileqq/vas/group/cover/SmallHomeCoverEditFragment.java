package com.tencent.mobileqq.vas.group.cover;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.group.guide.SmallHomeCoverEditGuideFragment;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mobileqq.zootopia.helper.SmallHomeHelper;
import com.tencent.qphone.base.util.QLog;
import fi3.bu;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0014R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00100\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/vas/group/cover/SmallHomeCoverEditFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initReport", "initView", "", "Fh", "Hh", "Gh", "getPageInfo", "Lcom/tencent/mobileqq/vas/data/e;", "pageInfo", "Ih", OcrConfig.CHINESE, "", "visibility", "Kh", "", "url", "Lcom/tencent/image/URLDrawable;", "yh", "Jh", "xh", "enable", "Lh", "Mh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "getContentLayoutId", "Lfi3/bu;", BdhLogUtil.LogTag.Tag_Conn, "Lfi3/bu;", "binding", "Lz23/e;", "D", "Lz23/e;", "bgService", "E", "Ljava/lang/String;", "curChooseBg", UserInfo.SEX_FEMALE, "curSetBg", "G", "defaultUrl", "H", "customUrl", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "I", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/mobileqq/vas/group/cover/a;", "J", "Lcom/tencent/mobileqq/vas/group/cover/a;", "coverEditReporter", "Lid3/d;", "K", "Lid3/d;", "dtReport", "<init>", "()V", "L", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeCoverEditFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private bu binding;

    /* renamed from: D, reason: from kotlin metadata */
    private final z23.e bgService = new z23.e();

    /* renamed from: E, reason: from kotlin metadata */
    private String curChooseBg = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String curSetBg = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String defaultUrl = "";

    /* renamed from: H, reason: from kotlin metadata */
    private String customUrl = "";

    /* renamed from: I, reason: from kotlin metadata */
    private final MMKVOptionEntity entity;

    /* renamed from: J, reason: from kotlin metadata */
    private final a coverEditReporter;

    /* renamed from: K, reason: from kotlin metadata */
    private final id3.d dtReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/group/cover/SmallHomeCoverEditFragment$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/vas/data/e;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<com.tencent.mobileqq.vas.data.e> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(com.tencent.mobileqq.vas.data.e result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SmallHomeCoverEditFragment.this.Ih(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SmallHomeCoverEditFragment", 1, "getPageInfo error " + error + " " + message);
        }
    }

    public SmallHomeCoverEditFragment() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        this.entity = from;
        this.coverEditReporter = new a();
        this.dtReport = new id3.d(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(SmallHomeCoverEditFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Hh();
        this$0.Lh(!Intrinsics.areEqual(this$0.curSetBg, ""));
        id3.d dVar = this$0.dtReport;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        dVar.c("clck", it, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(SmallHomeCoverEditFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
        this$0.Lh(!Intrinsics.areEqual(this$0.curSetBg, this$0.customUrl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(SmallHomeCoverEditFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(SmallHomeCoverEditFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        id3.d dVar = this$0.dtReport;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        dVar.c("clck", it, new LinkedHashMap());
        if (TextUtils.isEmpty(this$0.curChooseBg)) {
            this$0.xh();
            this$0.Hh();
            this$0.Lh(false);
        } else {
            this$0.Jh(this$0.curChooseBg);
            this$0.Lh(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(SmallHomeCoverEditFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        id3.d dVar = this$0.dtReport;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        dVar.c("clck", it, new LinkedHashMap());
        if (this$0.Fh()) {
            FragmentActivity activity = this$0.getActivity();
            if (activity == null) {
                return;
            }
            int dpToPx = ViewUtils.dpToPx(674.0f);
            IZootopiaC2CApi iZootopiaC2CApi = (IZootopiaC2CApi) QRoute.api(IZootopiaC2CApi.class);
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "act.supportFragmentManager");
            iZootopiaC2CApi.showAvatarPanel(supportFragmentManager, dpToPx, (Fragment) new SmallHomeCoverEditGuideFragment(), true);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MasterInfo masterInfo = new MasterInfo();
        masterInfo.setUin(peekAppRuntime.getCurrentAccountUin());
        VisitorInfo visitorInfo = new VisitorInfo();
        visitorInfo.setUin(peekAppRuntime.getCurrentAccountUin());
        ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.SetCover, ZootopiaSource.SUB_SOURCE_SET_COVER, null, 4, null);
        IVasZplanGroupApi iVasZplanGroupApi = (IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class);
        Context context = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        TransitPageConfig transitPageConfig = new TransitPageConfig();
        ExtInfo extInfo = new ExtInfo();
        extInfo.setUeExtras(SmallHomeHelper.f328312a.b());
        Unit unit = Unit.INSTANCE;
        iVasZplanGroupApi.openSmallHomeTransitPage(context, new TransitPageInfo(masterInfo, visitorInfo, transitPageConfig, extInfo), d16);
        this$0.coverEditReporter.a();
    }

    private final boolean Fh() {
        return this.entity.decodeBool("needGuide", true);
    }

    private final void Gh() {
        this.curChooseBg = this.customUrl;
        bu buVar = this.binding;
        if (buVar == null) {
            return;
        }
        buVar.f399156d.setVisibility(8);
        buVar.f399155c.setVisibility(0);
        buVar.f399158f.setVisibility(0);
        buVar.f399157e.setImageDrawable(yh(this.customUrl));
    }

    private final void Hh() {
        this.curChooseBg = "";
        bu buVar = this.binding;
        if (buVar == null) {
            return;
        }
        buVar.f399156d.setVisibility(0);
        buVar.f399155c.setVisibility(8);
        buVar.f399158f.setVisibility(8);
        buVar.f399157e.setImageDrawable(yh(this.defaultUrl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(com.tencent.mobileqq.vas.data.e pageInfo) {
        this.defaultUrl = pageInfo.getDefaultBgUrl();
        this.customUrl = pageInfo.getBgUrl();
        zh();
    }

    private final void Jh(final String url) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        this.curSetBg = url;
        Gh();
        this.bgService.g(appInterface, url, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.group.cover.SmallHomeCoverEditFragment$setCustomBg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.i("SmallHomeCoverEditFragment", 1, "update bg " + z16 + " " + url);
            }
        });
    }

    private final void Kh(int visibility) {
        bu buVar = this.binding;
        if (buVar != null) {
            buVar.f399159g.setVisibility(visibility);
            buVar.f399155c.setVisibility(visibility);
            buVar.f399158f.setVisibility(visibility);
        }
    }

    private final void Lh(boolean enable) {
        TextView textView;
        bu buVar = this.binding;
        if (buVar == null || (textView = buVar.f399165m) == null) {
            return;
        }
        textView.setEnabled(enable);
        if (enable) {
            textView.setBackgroundResource(R.drawable.gpz);
            textView.setTextColor(-1);
        } else {
            textView.setBackgroundResource(R.drawable.gpy);
            textView.setTextColor(Color.argb(128, 255, 255, 255));
        }
    }

    private final void Mh() {
        FragmentActivity activity = getActivity();
        final Resources resources = activity != null ? activity.getResources() : null;
        if (resources == null) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 0, resources.getString(R.string.f169837xv4), resources.getString(R.string.f169835xv2), resources.getString(R.string.f169834xv1), resources.getString(R.string.f169836xv3), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SmallHomeCoverEditFragment.Nh(SmallHomeCoverEditFragment.this, resources, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SmallHomeCoverEditFragment.Oh(dialogInterface, i3);
            }
        });
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(SmallHomeCoverEditFragment this$0, Resources res, DialogInterface dialogInterface, int i3) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(res, "$res");
        this$0.xh();
        this$0.customUrl = "";
        this$0.Hh();
        bu buVar = this$0.binding;
        RoundCornerImageView roundCornerImageView = buVar != null ? buVar.f399159g : null;
        if (roundCornerImageView != null) {
            roundCornerImageView.setVisibility(8);
        }
        bu buVar2 = this$0.binding;
        ImageView imageView = buVar2 != null ? buVar2.f399154b : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this$0.Lh(false);
        bu buVar3 = this$0.binding;
        if (buVar3 != null && (textView = buVar3.f399160h) != null) {
            textView.setTextColor(res.getColor(R.color.f8647i));
        }
        bu buVar4 = this$0.binding;
        TextView textView2 = buVar4 != null ? buVar4.f399160h : null;
        if (textView2 != null) {
            textView2.setText(this$0.getString(R.string.xvj));
        }
        this$0.coverEditReporter.b();
    }

    private final void getPageInfo() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        new z23.e().d(appInterface, appInterface.getLongAccountUin(), new b());
    }

    private final void initView() {
        setTitle("\u5c0f\u7a9d\u5c01\u9762");
        bu buVar = this.binding;
        if (buVar != null) {
            int dip2px = ViewUtils.dip2px(4.0f);
            buVar.f399157e.setCorner(dip2px);
            buVar.f399157e.getLayoutParams().height = (int) ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(36.0f)) * 0.42f);
            buVar.f399161i.setCorner(dip2px);
            buVar.f399159g.setCorner(dip2px);
            buVar.f399161i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmallHomeCoverEditFragment.Ah(SmallHomeCoverEditFragment.this, view);
                }
            });
            buVar.f399159g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmallHomeCoverEditFragment.Bh(SmallHomeCoverEditFragment.this, view);
                }
            });
            buVar.f399158f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmallHomeCoverEditFragment.Ch(SmallHomeCoverEditFragment.this, view);
                }
            });
            buVar.f399165m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmallHomeCoverEditFragment.Dh(SmallHomeCoverEditFragment.this, view);
                }
            });
            buVar.f399154b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmallHomeCoverEditFragment.Eh(SmallHomeCoverEditFragment.this, view);
                }
            });
        }
    }

    private final void xh() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        this.curSetBg = "";
        this.bgService.a(appInterface, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.group.cover.SmallHomeCoverEditFragment$deleteBg$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.i("SmallHomeCoverEditFragment", 1, "delete bg " + z16);
            }
        });
    }

    private final URLDrawable yh(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = 750;
        obtain.mRequestHeight = 315;
        Drawable drawable = getResources().getDrawable(R.drawable.i86, null);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(url, options)");
        return drawable2;
    }

    private final void zh() {
        bu buVar = this.binding;
        if (buVar == null) {
            return;
        }
        buVar.f399161i.setImageDrawable(yh(this.defaultUrl));
        if (TextUtils.isEmpty(this.customUrl)) {
            this.curChooseBg = "";
            this.curSetBg = "";
            Kh(8);
            buVar.f399154b.setVisibility(0);
            buVar.f399156d.setVisibility(0);
            buVar.f399157e.setImageDrawable(yh(this.defaultUrl));
            buVar.f399160h.setText(getString(R.string.xuz));
            this.coverEditReporter.b();
            return;
        }
        String str = this.customUrl;
        this.curChooseBg = str;
        this.curSetBg = str;
        Kh(0);
        buVar.f399154b.setVisibility(8);
        buVar.f399156d.setVisibility(8);
        buVar.f399159g.setImageDrawable(yh(this.customUrl));
        buVar.f399157e.setImageDrawable(yh(this.customUrl));
        buVar.f399160h.setTextColor(-16777216);
        buVar.f399160h.setText(getString(R.string.xva));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dfi;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.binding = bu.e(view.findViewById(R.id.pr5));
        initView();
        getPageInfo();
        initReport();
    }

    private final void initReport() {
        Intent intent;
        bu buVar = this.binding;
        if (buVar != null) {
            FragmentActivity activity = getActivity();
            int i3 = 0;
            if (activity != null && (intent = activity.getIntent()) != null) {
                i3 = intent.getIntExtra("edit_from", 0);
            }
            id3.d dVar = this.dtReport;
            LinearLayout root = buVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_xiaowo_cover_from", Integer.valueOf(i3));
            Unit unit = Unit.INSTANCE;
            dVar.k(root, "pg_zplan_set_xiaowo_cover", linkedHashMap);
            id3.d dVar2 = this.dtReport;
            RoundCornerImageView roundCornerImageView = buVar.f399161i;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "it.defaultCover");
            id3.d.i(dVar2, roundCornerImageView, "em_zplan_set_regular_cover", new LinkedHashMap(), false, false, null, false, false, 240, null);
            id3.d dVar3 = this.dtReport;
            ImageView imageView = buVar.f399154b;
            Intrinsics.checkNotNullExpressionValue(imageView, "it.addCover");
            id3.d.i(dVar3, imageView, ZootopiaSource.SUB_SOURCE_SET_COVER, new LinkedHashMap(), false, false, null, false, false, 240, null);
            id3.d dVar4 = this.dtReport;
            TextView textView = buVar.f399165m;
            Intrinsics.checkNotNullExpressionValue(textView, "it.update");
            id3.d.i(dVar4, textView, "em_zplan_xiaowo_cover_update", new LinkedHashMap(), false, false, null, false, false, 240, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(DialogInterface dialogInterface, int i3) {
    }
}
