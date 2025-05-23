package com.tencent.mobileqq.mini.ui;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial$AppMaterialInfo;
import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial$GetMaterialRelevantAppRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.server.CommonRequestObserver;
import com.tencent.mobileqq.mini.server.RequestCallback;
import com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppServlet;
import com.tencent.mobileqq.mini.ui.FileMaterialAppListAdapter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.NewIntent;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010\"\u001a\u00020\u001dJ\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u001dH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\u0006\u0010.\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListDialog;", "Lcom/tencent/mobileqq/mini/server/RequestCallback;", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$GetMaterialRelevantAppRsp;", "Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter$OnLoadMoreListener;", "mActivity", "Landroid/app/Activity;", "mFile", "Ljava/io/File;", "mMimeType", "", "(Landroid/app/Activity;Ljava/io/File;Ljava/lang/String;)V", "mContentView", "Landroid/view/View;", "mCurExtraInfo", "mDescFileName", "mDescFilePath", "mDialog", "Landroid/app/Dialog;", "mHasPendingRequest", "", "mListAdapter", "Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter;", "mMiniList", "Landroid/widget/LinearLayout;", "mRealMimeType", "mTitleTv", "Landroid/widget/TextView;", "mWaitDialog", "calcRealMimeType", "", "copyImageFileForLaunchMiniApp", "data", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "handleItemClicked", "hide", "initView", "isNeedResetImageFileForMiniApp", "onNeedLoadMore", "onReqFailed", "retCode", "", "errMsg", "onReqSucceed", "rsp", WebViewPlugin.KEY_REQUEST, "resetContentViewHeight", "show", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class FileMaterialAppListDialog implements RequestCallback<MiniAppFileMaterial$GetMaterialRelevantAppRsp>, LoadingMoreRecyclerAdapter.OnLoadMoreListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IMAGE_FILE_TYPE = "image";
    private static final float MIN_DISPLAY_ITEM_COUNT = 4.5f;
    private static final String TAG = "FileMaterialAppListDialog";
    private static final int TYPE_STRING_SIEZ = 2;
    private final Activity mActivity;
    private final View mContentView;
    private String mCurExtraInfo;
    private String mDescFileName;
    private String mDescFilePath;
    private final Dialog mDialog;
    private File mFile;
    private volatile boolean mHasPendingRequest;
    private final FileMaterialAppListAdapter mListAdapter;
    private final String mMimeType;
    private LinearLayout mMiniList;
    private volatile String mRealMimeType;
    private TextView mTitleTv;
    private Dialog mWaitDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListDialog$Companion;", "", "()V", "IMAGE_FILE_TYPE", "", "MIN_DISPLAY_ITEM_COUNT", "", "TAG", "TYPE_STRING_SIEZ", "", "calcContentHeight", "context", "Landroid/content/Context;", "itemCount", "getContentViewHeight", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float calcContentHeight(Context context, float itemCount) {
            Resources resources = context.getResources();
            return (itemCount * resources.getDimensionPixelSize(R.dimen.f130393)) + resources.getDimensionPixelSize(R.dimen.f130494);
        }

        public final int getContentViewHeight(Context context, int itemCount) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Math.min(ImmersiveUtils.getScreenHeight() - (ImmersiveUtils.getStatusBarHeight(context) + context.getResources().getDimensionPixelSize(R.dimen.f130191)), (int) Math.max(calcContentHeight(context, itemCount), calcContentHeight(context, FileMaterialAppListDialog.MIN_DISPLAY_ITEM_COUNT)));
        }

        Companion() {
        }
    }

    public FileMaterialAppListDialog(Activity mActivity, File mFile, String mMimeType) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(mFile, "mFile");
        Intrinsics.checkNotNullParameter(mMimeType, "mMimeType");
        this.mActivity = mActivity;
        this.mFile = mFile;
        this.mMimeType = mMimeType;
        this.mListAdapter = new FileMaterialAppListAdapter();
        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.dj_, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026al_app_list_dialog, null)");
        this.mContentView = inflate;
        Dialog createDialog = ActionSheetHelper.createDialog(mActivity, inflate);
        Intrinsics.checkNotNullExpressionValue(createDialog, "createDialog(mActivity, mContentView)");
        this.mDialog = createDialog;
        initView();
        calcRealMimeType();
    }

    private final void calcRealMimeType() {
        if (!Intrinsics.areEqual(this.mMimeType, "image/*")) {
            this.mRealMimeType = this.mMimeType;
            this.mListAdapter.setMimeType(this.mRealMimeType);
        } else {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.ui.d
                @Override // java.lang.Runnable
                public final void run() {
                    FileMaterialAppListDialog.calcRealMimeType$lambda$4(FileMaterialAppListDialog.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void calcRealMimeType$lambda$4(FileMaterialAppListDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String imageMimeType = com.tencent.mobileqq.utils.o.getImageMimeType(this$0.mFile.getAbsolutePath());
        if (imageMimeType == null || imageMimeType.length() == 0) {
            imageMimeType = this$0.mMimeType;
        }
        this$0.mRealMimeType = imageMimeType;
        this$0.mListAdapter.setMimeType(this$0.mRealMimeType);
        QLog.i(TAG, 2, "calcRealMimeType: " + this$0.mRealMimeType);
        if (this$0.mHasPendingRequest) {
            this$0.requestData();
        }
    }

    private final void copyImageFileForLaunchMiniApp(MiniAppFileMaterial$AppMaterialInfo data) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.ui.c
            @Override // java.lang.Runnable
            public final void run() {
                FileMaterialAppListDialog.copyImageFileForLaunchMiniApp$lambda$6(FileMaterialAppListDialog.this);
            }
        }, 64, new FileMaterialAppListDialog$copyImageFileForLaunchMiniApp$2(this, data), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyImageFileForLaunchMiniApp$lambda$6(FileMaterialAppListDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.videocut.utils.g gVar = com.tencent.videocut.utils.g.f384239a;
        String absolutePath = this$0.mFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "mFile.absolutePath");
        String str = this$0.mDescFilePath;
        Intrinsics.checkNotNull(str);
        gVar.b(absolutePath, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleItemClicked(MiniAppFileMaterial$AppMaterialInfo data) {
        if (isNeedResetImageFileForMiniApp() && !com.tencent.videocut.utils.g.f384239a.h(this.mDescFilePath)) {
            copyImageFileForLaunchMiniApp(data);
        } else if (isNeedResetImageFileForMiniApp()) {
            MiniAppLauncher.launchMiniAppByIdWithFile(this.mActivity, data.appid.get(), data.path.get(), data.f24954vt.get(), 1173, Collections.singletonList(new FileMaterialInfo(this.mRealMimeType, this.mDescFileName, this.mDescFilePath, this.mFile.length())));
        } else {
            MiniAppLauncher.launchMiniAppByIdWithFile(this.mActivity, data.appid.get(), data.path.get(), data.f24954vt.get(), 1173, Collections.singletonList(new FileMaterialInfo(this.mRealMimeType, this.mFile.getName(), this.mFile.getAbsolutePath(), this.mFile.length())));
        }
    }

    private final void initView() {
        View findViewById = this.mContentView.findViewById(R.id.reu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.ll_root_view)");
        this.mMiniList = (LinearLayout) findViewById;
        View findViewById2 = this.mContentView.findViewById(R.id.rlm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.tv_list_title)");
        this.mTitleTv = (TextView) findViewById2;
        TextView textView = null;
        if (QQTheme.isNowThemeIsNight()) {
            LinearLayout linearLayout = this.mMiniList;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMiniList");
                linearLayout = null;
            }
            linearLayout.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.iof));
            TextView textView2 = this.mTitleTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
            } else {
                textView = textView2;
            }
            textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f8938a));
        } else {
            LinearLayout linearLayout2 = this.mMiniList;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMiniList");
                linearLayout2 = null;
            }
            linearLayout2.setBackground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.ioe));
            TextView textView3 = this.mTitleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
            } else {
                textView = textView3;
            }
            textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f8928_));
        }
        ((ImageView) this.mContentView.findViewById(R.id.ree)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileMaterialAppListDialog.initView$lambda$0(FileMaterialAppListDialog.this, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.mContentView.findViewById(R.id.f163712rl4);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        recyclerView.setAdapter(this.mListAdapter);
        this.mListAdapter.setLoadMoreListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FileMaterialAppListDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    private final boolean isNeedResetImageFileForMiniApp() {
        List split$default;
        String str = this.mRealMimeType;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.mRealMimeType;
        Intrinsics.checkNotNull(str2);
        split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"/"}, false, 0, 6, (Object) null);
        if (split$default == null || split$default.size() != 2 || !Intrinsics.areEqual(split$default.get(0), "image")) {
            return false;
        }
        this.mDescFileName = this.mFile.getName() + "." + split$default.get(1);
        this.mDescFilePath = this.mFile.getAbsolutePath() + "." + split$default.get(1);
        return true;
    }

    private final void requestData() {
        String str = this.mRealMimeType;
        if (str == null || str.length() == 0) {
            this.mHasPendingRequest = true;
            return;
        }
        this.mHasPendingRequest = false;
        CommonRequestObserver commonRequestObserver = new CommonRequestObserver(MiniAppFileMaterial$GetMaterialRelevantAppRsp.class, this);
        NewIntent newIntent = new NewIntent(this.mActivity, GetMaterialRelevantAppServlet.class);
        newIntent.putExtra(GetMaterialRelevantAppServlet.KEY_MIME_TYPE, this.mRealMimeType);
        newIntent.putExtra(GetMaterialRelevantAppServlet.KEY_EXTRA_INFO, this.mCurExtraInfo);
        newIntent.setObserver(commonRequestObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    private final void resetContentViewHeight() {
        int contentViewHeight = INSTANCE.getContentViewHeight(this.mActivity, this.mListAdapter.getItemCount());
        View view = this.mContentView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = contentViewHeight;
        view.setLayoutParams(layoutParams);
    }

    public final void hide() {
        this.mDialog.dismiss();
    }

    @Override // com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter.OnLoadMoreListener
    public void onNeedLoadMore() {
        requestData();
    }

    @Override // com.tencent.mobileqq.mini.server.RequestCallback
    public void onReqFailed(long retCode, String errMsg) {
        QLog.e(TAG, 1, "onReqFailed: retCode=" + retCode + ", errMsg=" + errMsg);
        this.mListAdapter.setLoadingComplete(false, false);
        if (retCode != 0) {
            QQToast.makeText(this.mActivity, 1, R.string.xxn, 0).show();
        }
    }

    public final void show() {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.mDialog.show();
    }

    @Override // com.tencent.mobileqq.mini.server.RequestCallback
    public void onReqSucceed(MiniAppFileMaterial$GetMaterialRelevantAppRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.mCurExtraInfo = rsp.extra.get();
        TextView textView = this.mTitleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
            textView = null;
        }
        textView.setText(rsp.title.get());
        FileMaterialAppListAdapter fileMaterialAppListAdapter = this.mListAdapter;
        List<MiniAppFileMaterial$AppMaterialInfo> list = rsp.relevant_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.relevant_list.get()");
        fileMaterialAppListAdapter.addData(list);
        fileMaterialAppListAdapter.setShowLoadingMore(rsp.hasMore.get());
        fileMaterialAppListAdapter.setLoadingComplete(true, rsp.hasMore.get());
        fileMaterialAppListAdapter.setItemClickListener(new FileMaterialAppListAdapter.OnItemClickListener() { // from class: com.tencent.mobileqq.mini.ui.FileMaterialAppListDialog$onReqSucceed$1$1
            @Override // com.tencent.mobileqq.mini.ui.FileMaterialAppListAdapter.OnItemClickListener
            public void onItemClicked(MiniAppFileMaterial$AppMaterialInfo data) {
                Intrinsics.checkNotNullParameter(data, "data");
                FileMaterialAppListDialog.this.handleItemClicked(data);
            }
        });
        resetContentViewHeight();
    }
}
