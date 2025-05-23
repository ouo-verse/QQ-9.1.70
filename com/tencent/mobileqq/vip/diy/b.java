package com.tencent.mobileqq.vip.diy;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import e15.f;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends f {
    static IPatchRedirector $redirector_;
    private String C;

    public b(String str, View view, String str2) {
        super(str, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, view, str2);
        } else {
            this.C = str2;
            ((TemplateLikeView) view).d(1);
        }
    }

    @Override // e15.f
    protected ViewGroup.LayoutParams k(ViewGroup.LayoutParams layoutParams, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutParams, (Object) jSONObject);
        }
        this.f395369h = -2;
        this.f395370i = e(jSONObject.optString("height"));
        layoutParams.width = -2;
        layoutParams.height = -2;
        ((TemplateLikeView) this.f395367e).setContainerLayoutParams(this.f395369h, this.f395370i, UIUtils.b(this.f395367e.getContext(), jSONObject.optInt("lpd", 2) / 2), UIUtils.b(this.f395367e.getContext(), jSONObject.optInt("rpd", 2) / 2));
        return layoutParams;
    }

    @Override // e15.f
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (VasProfileTemplatePreloadHelper.BACKGROUND.equals(str)) {
            View view = this.f395367e;
            if (view instanceof TemplateLikeView) {
                ((TemplateLikeView) view).setVoteContainerBackground(u(str2, null));
                return;
            }
            return;
        }
        if ("style".equals(str)) {
            View view2 = this.f395367e;
            if (view2 instanceof TemplateLikeView) {
                ((TemplateLikeView) view2).d(!"1".equals(str2) ? 1 : 0);
                return;
            }
            return;
        }
        super.q(str, str2);
    }

    protected URLDrawable u(String str, DownloadParams.DecodeHandler decodeHandler) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) decodeHandler);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http") && !TextUtils.isEmpty(this.C)) {
            if (this.C.startsWith("http")) {
                str = this.C + str;
            } else {
                QLog.e("JsonInflateViewModel", 1, "it have the illegal url prefix=" + this.C);
            }
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = false;
        if (decodeHandler != null) {
            obtain.mMemoryCacheKeySuffix = decodeHandler.toString();
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        drawable2.setDecodeHandler(decodeHandler);
        return drawable2;
    }
}
