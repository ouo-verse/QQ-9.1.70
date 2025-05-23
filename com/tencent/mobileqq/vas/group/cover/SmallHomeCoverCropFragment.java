package com.tencent.mobileqq.vas.group.cover;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PortraitImageview;
import com.tencent.mobileqq.activity.photo.RegionView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/vas/group/cover/SmallHomeCoverCropFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "Dh", "Ah", "Fh", "", "url", "yh", "Hh", "Ih", "", OcrConfig.CHINESE, "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/activity/photo/PortraitImageview;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/photo/PortraitImageview;", "portraitImageview", "Lcom/tencent/mobileqq/activity/photo/RegionView;", "D", "Lcom/tencent/mobileqq/activity/photo/RegionView;", "regionView", "Lcom/tencent/mobileqq/zootopia/view/z;", "E", "Lcom/tencent/mobileqq/zootopia/view/z;", "loadingDialog", "Lcom/tencent/mobileqq/vas/group/cover/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vas/group/cover/b;", "getUploadUtil", "()Lcom/tencent/mobileqq/vas/group/cover/b;", "uploadUtil", "<init>", "()V", "G", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeCoverCropFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private PortraitImageview portraitImageview;

    /* renamed from: D, reason: from kotlin metadata */
    private RegionView regionView;

    /* renamed from: E, reason: from kotlin metadata */
    private z loadingDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private final b uploadUtil = new b();

    private final void Ah() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.group.cover.d
            @Override // java.lang.Runnable
            public final void run() {
                SmallHomeCoverCropFragment.Bh(SmallHomeCoverCropFragment.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(final SmallHomeCoverCropFragment this$0) {
        String str;
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("path")) == null) {
            str = "";
        }
        final Bitmap decodeFile = BitmapFactory.decodeFile(str);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.group.cover.f
            @Override // java.lang.Runnable
            public final void run() {
                SmallHomeCoverCropFragment.Ch(SmallHomeCoverCropFragment.this, decodeFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(SmallHomeCoverCropFragment this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        this$0.Dh(bitmap);
    }

    private final void Dh(Bitmap bitmap) {
        this.portraitImageview = new PortraitImageview(((QIphoneTitleBarFragment) this).mContentView.getContext());
        int screenWidth = ViewUtils.getScreenWidth() - 6;
        float f16 = screenWidth * 0.42f;
        PortraitImageview portraitImageview = this.portraitImageview;
        if (portraitImageview != null) {
            portraitImageview.setRestrict(screenWidth, (int) f16);
        }
        PortraitImageview portraitImageview2 = this.portraitImageview;
        if (portraitImageview2 != null) {
            portraitImageview2.setImageBitmap(bitmap);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.regionView = new RegionView(getActivity(), this.portraitImageview, 750, 314, 1, true);
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qcc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.photocrop_rootview)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.removeAllViews();
        viewGroup.addView(this.portraitImageview, layoutParams);
        viewGroup.addView(this.regionView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(id3.d dtReport, SmallHomeCoverCropFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(dtReport, "$dtReport");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        dtReport.c("clck", it, new LinkedHashMap());
        this$0.Fh();
    }

    private final void Fh() {
        z zVar = this.loadingDialog;
        if (zVar != null) {
            zVar.show();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.group.cover.e
            @Override // java.lang.Runnable
            public final void run() {
                SmallHomeCoverCropFragment.Gh(SmallHomeCoverCropFragment.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(final SmallHomeCoverCropFragment this$0) {
        File externalCacheDir;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RegionView regionView = this$0.regionView;
        Bitmap a16 = regionView != null ? regionView.a() : null;
        if (a16 == null) {
            return;
        }
        FragmentActivity activity = this$0.getActivity();
        String absolutePath = (activity == null || (externalCacheDir = activity.getExternalCacheDir()) == null) ? null : externalCacheDir.getAbsolutePath();
        if (absolutePath == null) {
            return;
        }
        String str = absolutePath + File.separator + "smallHomeBg.png";
        BitmapUtil.saveBitmap(a16, Bitmap.CompressFormat.PNG, 100, str, null);
        this$0.uploadUtil.c(str, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.group.cover.SmallHomeCoverCropFragment$upload$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                invoke(num.intValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                if (i3 != 0) {
                    SmallHomeCoverCropFragment.this.Hh();
                } else {
                    SmallHomeCoverCropFragment.this.yh(url);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh() {
        if (zh()) {
            return;
        }
        z zVar = this.loadingDialog;
        if (zVar != null) {
            zVar.dismiss();
        }
        QQToastUtil.showQQToast(1, R.string.xvc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        if (zh()) {
            return;
        }
        z zVar = this.loadingDialog;
        if (zVar != null) {
            zVar.dismiss();
        }
        FragmentActivity activity = getActivity();
        Resources resources = activity != null ? activity.getResources() : null;
        if (resources == null) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 0, resources.getString(R.string.xv6), resources.getString(R.string.xv5), resources.getString(R.string.xvb), resources.getString(R.string.xv_), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SmallHomeCoverCropFragment.Jh(SmallHomeCoverCropFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SmallHomeCoverCropFragment.Kh(SmallHomeCoverCropFragment.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(SmallHomeCoverCropFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() != null) {
            Intent intent = new Intent();
            intent.putExtra("edit_from", 0);
            QPublicFragmentActivity.start(this$0.getContext(), intent, SmallHomeCoverEditFragment.class);
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(SmallHomeCoverCropFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh(String url) {
        z23.e eVar = new z23.e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        eVar.g(appInterface, url, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.group.cover.SmallHomeCoverCropFragment$bindUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (!z16) {
                    SmallHomeCoverCropFragment.this.Hh();
                } else {
                    SmallHomeCoverCropFragment.this.Ih();
                }
            }
        });
    }

    private final boolean zh() {
        if (getActivity() == null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            return true;
        }
        FragmentActivity activity2 = getActivity();
        return activity2 != null && activity2.isDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dfh;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.uploadUtil.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        Resources resources;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ah();
        FragmentActivity activity = getActivity();
        if (activity == null || (resources = activity.getResources()) == null || (str = resources.getString(R.string.f169833xv0)) == null) {
            str = "";
        }
        setTitle(str);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        z zVar = new z(context, false, false, 6, null);
        this.loadingDialog = zVar;
        zVar.setCancelable(true);
        View finishView = view.findViewById(R.id.f163314pg3);
        final id3.d dVar = new id3.d(null, 1, null);
        finishView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.cover.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SmallHomeCoverCropFragment.Eh(id3.d.this, this, view2);
            }
        });
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        dVar.j(context2, view, "pg_zplan_set_xiaowo_cover_edit", new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(finishView, "finishView");
        id3.d.i(dVar, finishView, "em_zplan_xiaowo_cover_confirm", new LinkedHashMap(), false, false, null, false, false, 240, null);
    }
}
