package com.tencent.mobileqq.profilecard.template;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J#\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\u001c\u0010$\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010\u000bH\u0016JD\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u00102\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u00104\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u000bH\u0016J\u0012\u0010:\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010<\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010>\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00172\b\u0010A\u001a\u0004\u0018\u00010\u0012H\u0016J0\u0010B\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00172\b\u0010A\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/profilecard/template/EmptyApi;", "Lcom/tencent/mobileqq/profilecard/template/IDiyMoreInfoManager;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateManager;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateUtils;", "()V", "getDiyTemplateVersion", "", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/data/Card;", "getPhotoWallDiyView", "V", "Landroid/view/View;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)Landroid/view/View;", "getQZoneDiyView", "T", "key", "", "(Ljava/lang/String;)Landroid/view/View;", "getTemplateDrawable", "Landroid/graphics/drawable/Drawable;", "cardTemplate", "Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "isSaveCache", "", "isFullPath", WadlProxyConsts.PARAM_FILENAME, "initDiyTemplate", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", "initTemplateConfig", "backgroundColor", "styleId", "isDiy", "preNotifyOnCardUpdate", "updateAccountInfoForDeepDiy", "accountInfoView", "updateBaseInfoForDeepDiy", "baseInfoView", "updateItemThemeForDIYTemplate", "title", "Landroid/widget/TextView;", "content", "arrow", "Landroid/widget/ImageView;", "icon", "titleBg", "contentContainer", "updateLevelForDeepDiy", "levelView", "updateMetalForDeepDiy", "metalView", "updatePhotoWallForDeepDiy", "view", "updateQzoneForDeepDiy", "qZoneView", "updateSignForDeepDiy", "signView", "updateTroopMemInfoForDeepDiy", "troopMemInfoView", "updateViewAttr", "attr", "currentTemplate", "attrKey", "updateViewAttrForTemplate", "profilecard-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class EmptyApi implements IDiyMoreInfoManager, ITemplateManager, ITemplateUtils {
    static IPatchRedirector $redirector_;

    public EmptyApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateManager
    public long getDiyTemplateVersion(@NotNull Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this, (Object) card)).longValue();
        }
        Intrinsics.checkNotNullParameter(card, "card");
        return 0L;
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    @Nullable
    public <V extends View> V getPhotoWallDiyView(@Nullable ProfileCardInfo cardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (V) iPatchRedirector.redirect((short) 13, (Object) this, (Object) cardInfo);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    @Nullable
    public <T extends View> T getQZoneDiyView(@Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    @Nullable
    public Drawable getTemplateDrawable(@Nullable ProfileCardTemplate cardTemplate, boolean isSaveCache, boolean isFullPath, @Nullable String fileName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Drawable) iPatchRedirector.redirect((short) 16, this, cardTemplate, Boolean.valueOf(isSaveCache), Boolean.valueOf(isFullPath), fileName);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void initDiyTemplate(@Nullable QBaseActivity activity, @Nullable ProfileCardInfo cardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) cardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    public boolean initTemplateConfig(@Nullable ProfileCardTemplate cardTemplate, long backgroundColor, long styleId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 17, this, cardTemplate, Long.valueOf(backgroundColor), Long.valueOf(styleId))).booleanValue();
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public boolean isDiy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateManager
    public boolean preNotifyOnCardUpdate(@Nullable QBaseActivity activity, @Nullable ProfileCardInfo cardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity, (Object) cardInfo)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateAccountInfoForDeepDiy(@Nullable View accountInfoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) accountInfoView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateBaseInfoForDeepDiy(@Nullable View baseInfoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseInfoView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateItemThemeForDIYTemplate(@Nullable TextView title, @Nullable View content, @Nullable ImageView arrow, @Nullable View icon, @Nullable View titleBg, @Nullable View contentContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, title, content, arrow, icon, titleBg, contentContainer);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateLevelForDeepDiy(@Nullable View levelView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) levelView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateMetalForDeepDiy(@Nullable View metalView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) metalView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updatePhotoWallForDeepDiy(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateQzoneForDeepDiy(@NotNull View qZoneView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qZoneView);
        } else {
            Intrinsics.checkNotNullParameter(qZoneView, "qZoneView");
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateSignForDeepDiy(@Nullable View signView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) signView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateTroopMemInfoForDeepDiy(@Nullable View troopMemInfoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopMemInfoView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    public void updateViewAttr(@Nullable View view, @Nullable String attr, @Nullable ProfileCardTemplate currentTemplate, @Nullable String attrKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, view, attr, currentTemplate, attrKey);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateManager
    public void updateViewAttrForTemplate(@Nullable View view, @Nullable String attr, @Nullable ProfileCardTemplate currentTemplate, @Nullable String attrKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, view, attr, currentTemplate, attrKey);
        }
    }
}
