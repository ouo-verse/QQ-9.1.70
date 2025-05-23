package com.tencent.mobileqq.emoticon.data;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/MarketEmoticonInfo;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoticon", "Lcom/tencent/mobileqq/data/Emoticon;", "(Lcom/tencent/mobileqq/data/Emoticon;)V", "getEmoticon", "()Lcom/tencent/mobileqq/data/Emoticon;", "getBigImagePath", "", "getEmoticonType", "", "getName", "getThumbImagePath", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class MarketEmoticonInfo extends EmoticonInfo {
    static IPatchRedirector $redirector_;

    @NotNull
    private final Emoticon emoticon;

    public MarketEmoticonInfo(@NotNull Emoticon emoticon) {
        Intrinsics.checkNotNullParameter(emoticon, "emoticon");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticon);
        } else {
            this.emoticon = emoticon;
            this.type = 6;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getBigImagePath() {
        IEmoticonInfo iEmoticonInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Object obj = this.emoticon;
        if (obj instanceof IEmoticonInfo) {
            iEmoticonInfo = (IEmoticonInfo) obj;
        } else {
            iEmoticonInfo = null;
        }
        if (iEmoticonInfo == null) {
            return null;
        }
        return iEmoticonInfo.getBigImagePath();
    }

    @NotNull
    public final Emoticon getEmoticon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Emoticon) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.emoticon;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public int getEmoticonType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.type;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.emoticon.name;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getThumbImagePath() {
        IEmoticonInfo iEmoticonInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Object obj = this.emoticon;
        if (obj instanceof IEmoticonInfo) {
            iEmoticonInfo = (IEmoticonInfo) obj;
        } else {
            iEmoticonInfo = null;
        }
        if (iEmoticonInfo == null) {
            return null;
        }
        return iEmoticonInfo.getThumbImagePath();
    }
}
