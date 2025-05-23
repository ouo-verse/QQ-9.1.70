package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes12.dex */
public abstract class EmoticonPanelViewBinder extends EmoticonViewBinder {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "EmoticonPanelViewBinder";
    private static EmoticonPanelViewPool sViewPool;
    protected Context context;
    public int initPage;
    protected int sessionType;
    protected SparseArray<View> usingViews;

    /* loaded from: classes12.dex */
    class DefaultEmoticonAdapter extends EmoticonLinearLayout.EmoticonAdapter {
        static IPatchRedirector $redirector_ = null;
        private static final int SIZE_CLASSIC_EMOTICON = 30;
        private int classicEmoticonSize;
        private int panelViewType;

        public DefaultEmoticonAdapter(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonPanelViewBinder.this, i3);
            } else {
                this.classicEmoticonSize = (int) (EmoticonPanelViewBinder.this.context.getResources().getDisplayMetrics().density * 30.0f);
                this.panelViewType = i3;
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter
        public void bindView(int i3, RelativeLayout relativeLayout, ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), relativeLayout, viewGroup);
                return;
            }
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.f915355f);
            imageView.setVisibility(0);
            imageView.setTag(Boolean.FALSE);
            EmoticonInfo item = getItem(i3);
            relativeLayout.setTag(item);
            if (item != null && (item instanceof SystemAndEmojiEmoticonInfo)) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) item;
                int i16 = systemAndEmojiEmoticonInfo.code;
                int i17 = systemAndEmojiEmoticonInfo.emotionType;
                if (i17 == 1) {
                    if (i16 >= 0) {
                        String[] strArr = EmotcationConstants.SYS_EMOTICON_SYMBOL;
                        if (i16 < strArr.length) {
                            String str = strArr[i16];
                            if (str != null && str.startsWith("/") && str.length() > 1) {
                                str = str.substring(1);
                            }
                            if (str != null) {
                                relativeLayout.setContentDescription(str);
                            }
                        }
                    }
                } else if (i17 == 2) {
                    relativeLayout.setContentDescription(EmotcationConstants.getEmojiDesc(i16));
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            float f16 = EmoticonPanelViewBinder.this.context.getResources().getDisplayMetrics().density;
            if (item != null) {
                int i18 = item.type;
                if (i18 == 1 || i18 == 2 || i18 == 7) {
                    int i19 = this.classicEmoticonSize;
                    layoutParams.width = i19;
                    layoutParams.height = i19;
                }
                if (i18 != -1) {
                    Drawable drawable = item.getDrawable(EmoticonPanelViewBinder.this.context, f16);
                    if (drawable != null) {
                        imageView.setImageDrawable(drawable);
                    } else {
                        imageView.setVisibility(4);
                    }
                    imageView.setBackgroundDrawable(null);
                    return;
                }
                if ("delete".equals(item.action)) {
                    imageView.setImageResource(R.drawable.cjz);
                    relativeLayout.setContentDescription(EmoticonPanelViewBinder.this.context.getString(R.string.f230176yf));
                    return;
                }
                return;
            }
            imageView.setImageDrawable(null);
            imageView.setVisibility(4);
        }
    }

    /* loaded from: classes12.dex */
    public static final class PanelViewType {
        static IPatchRedirector $redirector_ = null;
        public static final int VIEW_TYPE_CLASSIC_EMOTICON = 2007;

        public PanelViewType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public EmoticonPanelViewBinder(Context context, int i3, int i16) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (context != null) {
                this.context = context;
                this.initPage = i16;
                this.usingViews = new SparseArray<>();
                return;
            }
            throw new IllegalArgumentException("Context MUST NOT be null!!!");
        }
    }

    public static void destroyViewPool() {
        EmoticonPanelViewPool emoticonPanelViewPool = sViewPool;
        if (emoticonPanelViewPool != null) {
            emoticonPanelViewPool.destroy();
            sViewPool = null;
        }
    }

    private boolean isPanelViewReuseable(int i3) {
        if (i3 != 2007) {
            return false;
        }
        return true;
    }

    protected View createEmoticonPanelView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, " createEmoticonPanelView, type=" + i3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        EmoticonLinearLayout emoticonLinearLayout = null;
        if (i3 == 2007) {
            EmoticonLinearLayout emoticonLinearLayout2 = new EmoticonLinearLayout(this.context, null);
            emoticonLinearLayout2.setPanelViewType(i3);
            emoticonLinearLayout = emoticonLinearLayout2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[Performance] createEmoticonPanelView, type=" + i3 + ",duration=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return emoticonLinearLayout;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonViewBinder
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.context = null;
        SparseArray<View> sparseArray = this.usingViews;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    public void destroyEmoticonPanelView(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        SparseArray<View> sparseArray = this.usingViews;
        if (sparseArray != null && (view = sparseArray.get(i3)) != null) {
            this.usingViews.remove(i3);
            int emoticonPanelViewType = getEmoticonPanelViewType(i3);
            if (!isPanelViewReuseable(emoticonPanelViewType)) {
                return;
            }
            if (sViewPool == null) {
                sViewPool = new EmoticonPanelViewPool();
            }
            sViewPool.addRecyleView(emoticonPanelViewType, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getEmoticonPanelView(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "getEmoticonPanelView, pageIndex=" + i3 + ",viewBinder=" + this);
        }
        int emoticonPanelViewType = getEmoticonPanelViewType(i3);
        EmoticonPanelViewPool emoticonPanelViewPool = sViewPool;
        if (emoticonPanelViewPool != null) {
            view = emoticonPanelViewPool.getRecyleView(emoticonPanelViewType);
        } else {
            view = null;
        }
        if (view == null) {
            view = createEmoticonPanelView(emoticonPanelViewType);
        }
        if (view != null) {
            if (this.usingViews == null) {
                this.usingViews = new SparseArray<>();
            }
            this.usingViews.put(i3, view);
            updatePanelView(view, i3);
        }
        return view;
    }

    protected abstract int getEmoticonPanelViewType(int i3);

    public int getIndicatorSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return getPanelPageCount();
    }

    protected View getUsingEmoticonPanelView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        SparseArray<View> sparseArray = this.usingViews;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i3);
    }

    protected abstract void updatePanelView(View view, int i3);
}
