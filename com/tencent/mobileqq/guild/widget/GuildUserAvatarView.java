package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;
import com.tencent.mobileqq.guild.avatar.GuildUserAvatarRepository;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes14.dex */
public class GuildUserAvatarView extends ImageView {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_AVATAR_SIZE_TYPE = -1;
    private static final String TAG = "Guild.user.GuildUserAvatarView.";
    private String mAvatarMeta;
    private final LinkedHashMap<Integer, Integer> mAvatarSizeMap;
    private String mGuildId;
    private boolean mNeedListenChange;
    private int mNeedSize;
    protected int mRoundRectRadius;
    private String mTag;
    private String mTinyId;
    private final com.tencent.mobileqq.guild.avatar.e mUrlChangeListener;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    static class InnerIGuildAvatarUrlChangeListener implements com.tencent.mobileqq.guild.avatar.e {
        private final WeakReference<GuildUserAvatarView> avatarViewRef;

        InnerIGuildAvatarUrlChangeListener(GuildUserAvatarView guildUserAvatarView) {
            this.avatarViewRef = new WeakReference<>(guildUserAvatarView);
        }

        @Override // com.tencent.mobileqq.guild.avatar.e
        public void doOnUrlChange(@NonNull String str, @NonNull String str2) {
            GuildUserAvatarView guildUserAvatarView = this.avatarViewRef.get();
            if (guildUserAvatarView != null && TextUtils.equals(str, guildUserAvatarView.mGuildId) && TextUtils.equals(str2, guildUserAvatarView.mTinyId)) {
                guildUserAvatarView.loadImage("mUrlChangeListener");
                QLog.d(guildUserAvatarView.mTag, 1, "doOnUrlChange guildId:", str, " tinyId:", str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int i3 = GuildUserAvatarView.this.mRoundRectRadius;
            if (i3 < 0) {
                i3 = view.getWidth() / 2;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), i3);
        }
    }

    public GuildUserAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTag = TAG;
        this.mGuildId = "0";
        this.mTinyId = "";
        this.mAvatarMeta = "";
        this.mNeedListenChange = true;
        this.mNeedSize = -1;
        this.mRoundRectRadius = -1;
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.mUrlChangeListener = new InnerIGuildAvatarUrlChangeListener(this);
        init();
    }

    private int getAvatarNeedSize(int i3) {
        for (Map.Entry<Integer, Integer> entry : this.mAvatarSizeMap.entrySet()) {
            if (i3 < entry.getKey().intValue()) {
                return entry.getValue().intValue();
            }
        }
        return 2;
    }

    private void init() {
        initAvatarSizeMap();
        setClipToOutline(true);
        setOutlineProvider(new a());
    }

    private void initAvatarSizeMap() {
        this.mAvatarSizeMap.put(70, 4);
        this.mAvatarSizeMap.put(120, 3);
        this.mAvatarSizeMap.put(210, 0);
        this.mAvatarSizeMap.put(640, 1);
        this.mAvatarSizeMap.put(1024, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage(String str) {
        if (TextUtils.isEmpty(this.mTinyId) && TextUtils.isEmpty(this.mAvatarMeta)) {
            QLog.w(this.mTag, 1, "loadImage params error " + this.mGuildId + "-" + this.mTinyId + "-" + str);
            return;
        }
        if (this.mNeedSize == -1) {
            QLog.w(this.mTag, 1, "loadImage size error " + this.mGuildId + "-" + this.mTinyId + "-" + this.mNeedSize + "-" + str);
            return;
        }
        if (!TextUtils.isEmpty(this.mAvatarMeta)) {
            ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadAvatarByTinyIdAndAvatarMeta(this.mGuildId, this.mTinyId, this.mAvatarMeta, this.mNeedSize, this);
        } else {
            ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadAvatarByTinyId(this.mGuildId, this.mTinyId, this.mNeedSize, this);
        }
    }

    public void clearAvatarTag() {
        setTag(R.id.f165440w05, null);
    }

    public String getTinyId() {
        return this.mTinyId;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.mNeedListenChange) {
            GuildUserAvatarRepository.f(this.mUrlChangeListener);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mNeedListenChange) {
            GuildUserAvatarRepository.k(this.mUrlChangeListener);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i3);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.mNeedSize = getAvatarNeedSize(i3);
        loadImage(MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED);
    }

    public void setAvatarMeta(String str, String str2, String str3) {
        if (!TextUtils.equals(this.mTinyId, str2)) {
            clearAvatarTag();
        }
        this.mGuildId = str;
        this.mTinyId = str2;
        this.mAvatarMeta = str3;
        if (this.mNeedSize != -1) {
            loadImage("setAvatarMeta");
        }
    }

    public void setAvatarSize(int i3) {
        this.mNeedSize = i3;
    }

    public void setAvatarTinyId(String str, String str2) {
        if (!TextUtils.equals(this.mTinyId, str2)) {
            clearAvatarTag();
        }
        this.mGuildId = str;
        this.mTinyId = str2;
        if (this.mNeedSize != -1) {
            loadImage("setAvatarTinyId");
        }
    }

    public void setLogTag(String str) {
        this.mTag = TAG + str;
    }

    public void setNeedListenChange(boolean z16) {
        this.mNeedListenChange = z16;
    }

    public void setRoundRect(int i3) {
        int i16 = this.mRoundRectRadius;
        if (i3 != i16) {
            if (i3 >= 0 || i16 >= 0) {
                this.mRoundRectRadius = i3;
                invalidateOutline();
            }
        }
    }

    @Override // android.view.View
    public void setTag(final int i3, final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.setTag(i3, obj);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.GuildUserAvatarView.1
                @Override // java.lang.Runnable
                public void run() {
                    GuildUserAvatarView.super.setTag(i3, obj);
                }
            });
            QLog.e(this.mTag, 1, "setTag in subThread error");
        }
    }

    public void setUrl(String str) {
        ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadAvatarByUrl(str, this, getWidth(), getHeight());
    }

    public GuildUserAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTag = TAG;
        this.mGuildId = "0";
        this.mTinyId = "";
        this.mAvatarMeta = "";
        this.mNeedListenChange = true;
        this.mNeedSize = -1;
        this.mRoundRectRadius = -1;
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.mUrlChangeListener = new InnerIGuildAvatarUrlChangeListener(this);
        init();
    }

    public GuildUserAvatarView(Context context) {
        super(context);
        this.mTag = TAG;
        this.mGuildId = "0";
        this.mTinyId = "";
        this.mAvatarMeta = "";
        this.mNeedListenChange = true;
        this.mNeedSize = -1;
        this.mRoundRectRadius = -1;
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.mUrlChangeListener = new InnerIGuildAvatarUrlChangeListener(this);
        init();
    }
}
