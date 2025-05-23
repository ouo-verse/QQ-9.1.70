package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.play.AEPlayShowGridAdapter;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes32.dex */
public class AEPlayShowGridViewHolder extends RecyclerView.ViewHolder implements URLDrawable.URLDrawableListener2, IProgressObserver {
    private static final String APNG_BASE_PATH;
    private static final String APNG_DIR_NAME = "play_show_apng";
    private final String TAG;
    private int layoutType;
    private URLDrawable mApngUrlDrawable;
    private String mId;
    private ItemClickCallback mItemClickCallback;
    private String mPlayImageUrl;
    AEMaterialMetaData mPlayMaterial;
    private View mPlayShowBottomShadow;
    private ImageView mPlayShowImage;
    private View mPlayShowInfoContainer;
    private ProgressBar mPlayShowProgressBar;
    private TextView mPlayShowText;
    private String mPlayText;
    private int mPosition;
    private static final Drawable APNG_LOADING_DRAWABLE = getAppContext().getResources().getDrawable(R.drawable.is9);
    private static final Map<String, WeakReference<URLDrawable>> APNG_CACHE = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public interface ItemClickCallback {
        void onItemClicked(View view, AEMaterialMetaData aEMaterialMetaData, int i3);
    }

    static {
        File file = new File(g.c.a.f65283a, APNG_DIR_NAME);
        APNG_BASE_PATH = file.getPath();
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public AEPlayShowGridViewHolder(final View view, AEPlayShowGridAdapter.SizeInfo sizeInfo, ItemClickCallback itemClickCallback, int i3) {
        super(view);
        this.TAG = "AEPlayShowGridViewHolder";
        this.mPosition = -1;
        this.mId = "";
        this.mPlayText = "";
        this.mPlayImageUrl = "";
        this.layoutType = i3;
        if (i3 == 1) {
            view.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    int a16 = x.a(10.0f);
                    int i16 = a16 * 2;
                    int i17 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels - i16;
                    int height = viewGroup.getHeight() - a16;
                    int i18 = (i17 * 16) / 9;
                    if (i18 > height) {
                        i17 = (height * 9) / 16;
                    } else {
                        height = i18;
                    }
                    marginLayoutParams.width = i17;
                    marginLayoutParams.height = height;
                    int width = a16 + (((viewGroup.getWidth() - i17) - i16) / 2);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("AEPlayShowGridViewHolder", 4, "one itemHeight " + height + " itemWidth: " + i17 + " screenWidth: " + BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels + " viewWidth: " + viewGroup.getWidth() + " padding: " + width);
                    }
                    view.setLayoutParams(marginLayoutParams);
                    viewGroup.setPadding(width, 0, 0, 0);
                }
            });
        }
        this.mItemClickCallback = itemClickCallback;
        this.mPlayShowImage = (ImageView) view.findViewById(R.id.rnl);
        this.mPlayShowInfoContainer = view.findViewById(R.id.rnm);
        this.mPlayShowText = (TextView) view.findViewById(R.id.rnp);
        this.mPlayShowProgressBar = (ProgressBar) view.findViewById(R.id.rno);
        this.mPlayShowBottomShadow = view.findViewById(R.id.rnn);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = sizeInfo.itemWidth;
        layoutParams.height = sizeInfo.itemHeight;
        view.setLayoutParams(layoutParams);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                AEPlayShowGridViewHolder aEPlayShowGridViewHolder = AEPlayShowGridViewHolder.this;
                if (aEPlayShowGridViewHolder.mPlayMaterial != null && aEPlayShowGridViewHolder.mItemClickCallback != null) {
                    ItemClickCallback itemClickCallback2 = AEPlayShowGridViewHolder.this.mItemClickCallback;
                    AEPlayShowGridViewHolder aEPlayShowGridViewHolder2 = AEPlayShowGridViewHolder.this;
                    itemClickCallback2.onItemClicked(view2, aEPlayShowGridViewHolder2.mPlayMaterial, aEPlayShowGridViewHolder2.mPosition);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        view.findViewById(R.id.rnk).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AEPlayShowGridViewHolder.this.lambda$new$0(view2);
            }
        });
    }

    private void bindContent(AEMaterialMetaData aEMaterialMetaData) {
        String str;
        this.mId = aEMaterialMetaData.f69050id;
        if (TextUtils.isEmpty(aEMaterialMetaData.playShowDisplayText)) {
            str = "";
        } else {
            str = aEMaterialMetaData.playShowDisplayText;
        }
        this.mPlayText = str;
        this.mPlayImageUrl = aEMaterialMetaData.playShowCoverImg;
        String str2 = APNG_BASE_PATH + File.separator + this.mPlayImageUrl.hashCode() + "_" + this.mId.hashCode() + ".png";
        showTemplateInfoViews();
        URLDrawable apngDrawable = getApngDrawable(str2, this.mPlayImageUrl);
        this.mApngUrlDrawable = apngDrawable;
        if (apngDrawable != null) {
            apngDrawable.setURLDrawableListener(this);
            this.mPlayShowImage.setImageDrawable(this.mApngUrlDrawable);
        }
    }

    public static void clearApngCache() {
        APNG_CACHE.clear();
    }

    static /* bridge */ /* synthetic */ Context f() {
        return getAppContext();
    }

    private URLDrawable getApngDrawable(String str, String str2) {
        return VasApngUtil.getApngDrawable(str, str2, APNG_LOADING_DRAWABLE, null, "-GY-PLAY-SHOW-", null);
    }

    private static Context getAppContext() {
        return BaseApplicationImpl.getApplication();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        ItemClickCallback itemClickCallback;
        EventCollector.getInstance().onViewClickedBefore(view);
        AEMaterialMetaData aEMaterialMetaData = this.mPlayMaterial;
        if (aEMaterialMetaData != null && (itemClickCallback = this.mItemClickCallback) != null) {
            itemClickCallback.onItemClicked(view, aEMaterialMetaData, this.mPosition);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void showTemplateInfoViews() {
        this.mPlayShowInfoContainer.setVisibility(0);
        if (this.layoutType != 1) {
            this.mPlayShowBottomShadow.setVisibility(0);
        }
        this.mPlayShowText.setText(this.mPlayText);
    }

    public void bind(AEMaterialMetaData aEMaterialMetaData, int i3) {
        this.mPlayMaterial = aEMaterialMetaData;
        this.mPosition = i3;
        URLDrawable uRLDrawable = this.mApngUrlDrawable;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
        }
        bindContent(aEMaterialMetaData);
        this.mPlayShowProgressBar.setVisibility(8);
    }

    public void onDownloadStart() {
        this.mPlayShowProgressBar.setVisibility(0);
        this.mPlayShowProgressBar.setProgress(0);
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        showTemplateInfoViews();
    }

    public void resetProgress() {
        this.mPlayShowProgressBar.setVisibility(8);
    }

    @Override // com.tencent.aelight.camera.ae.play.IProgressObserver
    public void onDownloadFinish(String str, final boolean z16) {
        if (str == null || !str.equals(this.mPlayMaterial.f69050id)) {
            return;
        }
        ms.a.f("AEPlayShowGridViewHolder", "\u3010Play Item\u3011onDownloadFinish id:" + str);
        ms.a.f("AEPlayShowGridViewHolder", "\u3010Play Item\u3011onDownloadFinish isSuccess:" + z16);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.4
            @Override // java.lang.Runnable
            public void run() {
                AEPlayShowGridViewHolder.this.mPlayShowProgressBar.setVisibility(8);
                if (z16) {
                    return;
                }
                QQToast.makeText(AEPlayShowGridViewHolder.f(), AEPlayShowGridViewHolder.f().getString(R.string.gru), 0).show();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.play.IProgressObserver
    public void onProgressUpdate(String str, final int i3) {
        if (str == null || !str.equals(this.mPlayMaterial.f69050id)) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.3
            @Override // java.lang.Runnable
            public void run() {
                if (AEPlayShowGridViewHolder.this.mPlayShowProgressBar.getVisibility() != 0) {
                    AEPlayShowGridViewHolder.this.mPlayShowProgressBar.setVisibility(0);
                }
                AEPlayShowGridViewHolder.this.mPlayShowProgressBar.setProgress(i3);
            }
        });
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener2
    public void onFileDownloaded(URLDrawable uRLDrawable) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
    }
}
