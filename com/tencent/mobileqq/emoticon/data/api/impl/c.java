package com.tencent.mobileqq.emoticon.data.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.data.EmoticonDataSource;
import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100B-\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010.\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b/\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR'\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\r\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u0010\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/impl/c;", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "", "getTabType", "", "getTabName", "Landroid/graphics/drawable/Drawable;", "getTabIcon", "", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "getEmoticons", "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource;", "getDataSource", "a", "I", "type", "b", "Ljava/lang/String;", "name", "c", "iconResId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", EmojiManagerServiceConstant.PARAMS_EMOTICON_LIST, "e", "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource;", "getEmoticonDataSource", "()Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource;", "(Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource;)V", "emoticonDataSource", "f", "getIconURL", "()Ljava/lang/String;", "setIconURL", "(Ljava/lang/String;)V", MiniBoxNoticeInfo.KEY_ICON_URL, "", "g", "Ljava/lang/Object;", "getBusinessData", "()Ljava/lang/Object;", "setBusinessData", "(Ljava/lang/Object;)V", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "<init>", "(ILjava/lang/String;I)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements EmoticonTabInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int iconResId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<EmoticonInfo> emoticonList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EmoticonDataSource emoticonDataSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String iconURL;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object businessData;

    public c(int i3, @NotNull String name, int i16) {
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), name, Integer.valueOf(i16));
            return;
        }
        this.type = i3;
        this.name = name;
        this.iconResId = i16;
        this.emoticonList = new ArrayList<>();
    }

    @NotNull
    public final ArrayList<EmoticonInfo> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.emoticonList;
    }

    public final void b(@Nullable EmoticonDataSource emoticonDataSource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonDataSource);
        } else {
            this.emoticonDataSource = emoticonDataSource;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonTabInfo
    @Nullable
    public EmoticonDataSource getDataSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (EmoticonDataSource) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.emoticonDataSource;
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonTabInfo
    @Nullable
    public List<EmoticonInfo> getEmoticons() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.emoticonList;
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonTabInfo
    @Nullable
    public Drawable getTabIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        int i3 = this.iconResId;
        if (i3 == 0) {
            return null;
        }
        return MobileQQ.sMobileQQ.getDrawable(i3);
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonTabInfo
    @NotNull
    public String getTabName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.name;
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonTabInfo
    public int getTabType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.type;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i3, @NotNull String name, @Nullable String str, @Nullable Object obj) {
        this(i3, name, 0);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), name, str, obj);
        } else {
            this.iconURL = str;
            this.businessData = obj;
        }
    }
}
