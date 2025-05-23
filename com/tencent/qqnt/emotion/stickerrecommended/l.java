package com.tencent.qqnt.emotion.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/l;", "Lcom/tencent/qqnt/emotion/stickerrecommended/b;", "", "keyword", "", "Lcom/tencent/qqnt/emotion/stickerrecommended/g;", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "a", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;)V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class l extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.stickerrecommended.l$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31349);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l(@Nullable BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.b, com.tencent.qqnt.emotion.stickerrecommended.h
    public boolean a(@Nullable BaseQQAppInterface app, @Nullable String keyword) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) app, (Object) keyword)).booleanValue();
        }
        if (TextUtils.isEmpty(keyword)) {
            return false;
        }
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        ArrayList<Integer> allAniStickerOrderList = QQSysFaceUtil.getAllAniStickerOrderList();
        if (allAniStickerOrderList != null && allAniStickerOrderList.size() >= 1) {
            Iterator<Integer> it = allAniStickerOrderList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (next == null) {
                    QLog.e("StickerRecAniStickerHandleListener", 1, "[handleFilter] error, localId is null!");
                } else {
                    String[] keywords = resImpl.getKeywords(next.intValue());
                    if (keywords != null) {
                        contains = ArraysKt___ArraysKt.contains(keywords, keyword);
                        if (contains) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.h
    @Nullable
    public List<g> b(@Nullable String keyword) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyword);
        }
        if (TextUtils.isEmpty(keyword)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecAniStickerHandleListener", 2, "onSearchStickerRecLocalEmoticon start.");
        }
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        ArrayList<Integer> allAniStickerOrderList = QQSysFaceUtil.getAllAniStickerOrderList();
        if (allAniStickerOrderList == null || allAniStickerOrderList.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = allAniStickerOrderList.iterator();
        while (it.hasNext()) {
            Integer localId = it.next();
            Intrinsics.checkNotNullExpressionValue(localId, "localId");
            String[] keywords = resImpl.getKeywords(localId.intValue());
            if (keywords != null) {
                contains = ArraysKt___ArraysKt.contains(keywords, keyword);
                if (contains) {
                    arrayList.add(new k(localId.intValue()));
                }
            }
        }
        return arrayList;
    }
}
