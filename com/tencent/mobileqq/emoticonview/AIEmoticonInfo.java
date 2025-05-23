package com.tencent.mobileqq.emoticonview;

import androidx.annotation.Nullable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AIEmoticonInfo extends EmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int ITEM_TYPE_BANNER = 1;
    public static final int ITEM_TYPE_NORMAL = 0;
    public String apngUrl;
    public String bannerPageUrl;
    public boolean isApng;
    public int itemType;
    public String md5;
    public int refId;
    public int templateId;
    public String url;

    public AIEmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.itemType = 0;
            this.isApng = false;
        }
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof AIEmoticonInfo)) {
            return false;
        }
        return ((AIEmoticonInfo) obj).url.equals(this.url);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getBigImageURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.url;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public Option getOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Option) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        BaseApplication context = BaseApplication.getContext();
        return Option.obtain().setUrl(this.url).setLoadingDrawable(context.getResources().getDrawable(R.drawable.c0i)).setFailDrawable(context.getResources().getDrawable(R.drawable.o4e));
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getThumbURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.url;
    }
}
