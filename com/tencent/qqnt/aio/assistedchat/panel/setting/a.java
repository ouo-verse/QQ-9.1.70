package com.tencent.qqnt.aio.assistedchat.panel.setting;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUIListItem;
import com.tencent.mobileqq.widget.listitem.ac;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00028\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J,\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00028\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/a;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "V", "Lcom/tencent/mobileqq/widget/listitem/w;", "T", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingListItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "L", "view", "", "position", "", "", "payloads", "", "K", "", "k", "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "imageUrl", "l", "Lcom/tencent/mobileqq/widget/listitem/w;", "J", "()Lcom/tencent/mobileqq/widget/listitem/w;", "simpleConfig", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/widget/listitem/w;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a<V extends QUIListItem<?>, T extends w<V>> extends w<AssistedChatPanelSettingListItem<V>> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String imageUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final T simpleConfig;

    public a(@NotNull String imageUrl, @NotNull T simpleConfig) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(simpleConfig, "simpleConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) imageUrl, (Object) simpleConfig);
        } else {
            this.imageUrl = imageUrl;
            this.simpleConfig = simpleConfig;
        }
    }

    @NotNull
    public final T J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.simpleConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull AssistedChatPanelSettingListItem<V> view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.simpleConfig.m(view.a(), position, payloads);
        view.b(this.imageUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public AssistedChatPanelSettingListItem<V> H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AssistedChatPanelSettingListItem) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        ac n3 = this.simpleConfig.n(parent);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AssistedChatPanelSettingListItem<V> assistedChatPanelSettingListItem = new AssistedChatPanelSettingListItem<>(context, n3);
        assistedChatPanelSettingListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return assistedChatPanelSettingListItem;
    }
}
