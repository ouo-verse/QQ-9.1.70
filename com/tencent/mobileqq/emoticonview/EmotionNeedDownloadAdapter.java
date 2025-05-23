package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ProgressButton;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class EmotionNeedDownloadAdapter extends AbsBigEmotionUpdateAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final int DOWN_BTN_DOWNING = 1;
    public static final int DOWN_BTN_IDLE = 2;
    protected final int downBtnRadius;
    protected int downBtnStatus;
    EmoticonPackageDownloadListener mEPDownloadListener;
    EmotionPanelPayBackListener mPayBackListener;

    public EmotionNeedDownloadAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
            return;
        }
        this.downBtnStatus = 2;
        this.downBtnRadius = ViewUtils.dip2px(2.0f);
        this.mPayBackListener = new EmotionPanelPayBackListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionNeedDownloadAdapter.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticon.EmotionPanelPayBackListener
            public void onPayBack(int i18) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i18);
                } else {
                    EmotionNeedDownloadAdapter.this.payBack(i18);
                }
            }
        };
        this.mEPDownloadListener = new EmoticonPackageDownloadListener() { // from class: com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionNeedDownloadAdapter.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
            public void onCoverComplete(EmoticonPackage emoticonPackage, int i18, int i19) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, emoticonPackage, Integer.valueOf(i18), Integer.valueOf(i19));
                } else {
                    EmotionNeedDownloadAdapter.this.refreshCover(emoticonPackage);
                }
            }

            @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
            public void onPackageEnd(EmoticonPackage emoticonPackage, int i18) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) emoticonPackage, i18);
                } else {
                    EmotionNeedDownloadAdapter.this.packageDownloadEnd(emoticonPackage, i18);
                }
            }

            @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
            public void onPackageProgress(EmoticonPackage emoticonPackage, int i18, int i19) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, emoticonPackage, Integer.valueOf(i18), Integer.valueOf(i19));
                } else {
                    EmotionNeedDownloadAdapter.this.refreashProgress(emoticonPackage, i18, i19);
                }
            }

            @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
            public void onPackageStart(EmoticonPackage emoticonPackage) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                } else {
                    EmotionNeedDownloadAdapter.this.packageDownloadStart(emoticonPackage);
                }
            }
        };
        com.tencent.mobileqq.emoticon.b.b().addEmoticonPackageDownloadListener(this.mEPDownloadListener);
        com.tencent.mobileqq.emoticon.c.c().a(this.mPayBackListener);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.destory();
        com.tencent.mobileqq.emoticon.b.b().removeEmoticonPackageDownloadListener(this.mEPDownloadListener);
        com.tencent.mobileqq.emoticon.c.c().e(this.mPayBackListener);
    }

    public void packageDownloadEnd(EmoticonPackage emoticonPackage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonPackage, i3);
        }
    }

    public void packageDownloadStart(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonPackage);
        }
    }

    public void payBack(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    public void refreashProgress(EmoticonPackage emoticonPackage, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void refreshCover(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonPackage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setProgressDrawable(@NonNull ProgressButton progressButton) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) progressButton);
        } else {
            progressButton.setProgressDrawable(progressButton.b(RichStatus.TOPIC_COLOR, this.downBtnRadius));
        }
    }
}
