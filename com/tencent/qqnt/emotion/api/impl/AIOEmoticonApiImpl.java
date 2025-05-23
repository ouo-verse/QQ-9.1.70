package com.tencent.qqnt.emotion.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceResImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/emotion/api/impl/AIOEmoticonApiImpl;", "Lcom/tencent/qqnt/emotion/api/IAIOEmoticonApi;", "()V", "convertToLocal", "", "serverId", "emojiType", "convertToServer", "localId", "getEmojiDrawable", "Landroid/graphics/drawable/Drawable;", "isDynamicType", "", "isDynamicResReady", "isEmoReady", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class AIOEmoticonApiImpl implements IAIOEmoticonApi {
    static IPatchRedirector $redirector_;

    public AIOEmoticonApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IAIOEmoticonApi
    public int convertToLocal(int serverId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(serverId), Integer.valueOf(emojiType))).intValue();
        }
        if (emojiType != 1) {
            if (emojiType != 2) {
                return -1;
            }
            return QQSysAndEmojiResMgr.getInstance().getResImpl(emojiType).getLocalId(serverId);
        }
        return QQSysFaceUtil.convertToLocal(serverId);
    }

    @Override // com.tencent.qqnt.emotion.api.IAIOEmoticonApi
    public int convertToServer(int localId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(localId), Integer.valueOf(emojiType))).intValue();
        }
        if (emojiType != 1) {
            if (emojiType != 2) {
                return -1;
            }
            return QQSysAndEmojiResMgr.getInstance().getResImpl(emojiType).getServerId(localId);
        }
        return QQSysFaceUtil.convertToServer(localId);
    }

    @Override // com.tencent.qqnt.emotion.api.IAIOEmoticonApi
    @Nullable
    public Drawable getEmojiDrawable(int localId, int emojiType, boolean isDynamicType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(localId), Integer.valueOf(emojiType), Boolean.valueOf(isDynamicType));
        }
        if (emojiType != 1) {
            if (emojiType != 2) {
                return null;
            }
            return QQEmojiUtil.getEmojiDrawable(localId);
        }
        if (isDynamicType) {
            return QQSysFaceUtil.getFaceGifDrawable(localId);
        }
        return QQSysFaceUtil.getFaceDrawable(localId);
    }

    @Override // com.tencent.qqnt.emotion.api.IAIOEmoticonApi
    public boolean isDynamicResReady(int localId, int emojiType) {
        QQSysFaceResImpl qQSysFaceResImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(localId), Integer.valueOf(emojiType))).booleanValue();
        }
        if (emojiType == 1) {
            QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
            if (resImpl instanceof QQSysFaceResImpl) {
                qQSysFaceResImpl = (QQSysFaceResImpl) resImpl;
            } else {
                qQSysFaceResImpl = null;
            }
            if (qQSysFaceResImpl != null) {
                return qQSysFaceResImpl.isDynamicResReady(convertToServer(localId, emojiType));
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.api.IAIOEmoticonApi
    public boolean isEmoReady(int localId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(localId), Integer.valueOf(emojiType))).booleanValue();
        }
        if (emojiType != 1) {
            if (emojiType != 2) {
                return false;
            }
            return QQSysAndEmojiResMgr.getInstance().getResImpl(emojiType).isResReady(localId);
        }
        return QQSysAndEmojiResMgr.getInstance().getResImpl(emojiType).isResReady(convertToServer(localId, emojiType));
    }
}
