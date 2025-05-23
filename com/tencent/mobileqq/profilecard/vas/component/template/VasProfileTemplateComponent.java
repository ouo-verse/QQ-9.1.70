package com.tencent.mobileqq.profilecard.vas.component.template;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ITemplateManager;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController;
import com.tencent.mobileqq.profilecard.vas.component.accountinfo.ProfileAdWindowHelper;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoManagerImpl;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.profilecard.IProfileTemplateController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 C2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001CB\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J8\u0010\u0019\u001a\n \u001b*\u0004\u0018\u0001H\u001aH\u001a\"\u0010\b\u0000\u0010\u001a*\n \u001b*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\t0\tH\u0096\u0001\u00a2\u0006\u0002\u0010\u001dJ8\u0010\u001e\u001a\n \u001b*\u0004\u0018\u0001H\u001fH\u001f\"\u0010\b\u0000\u0010\u001f*\n \u001b*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001\u00a2\u0006\u0002\u0010 JA\u0010!\u001a\n \u001b*\u0004\u0018\u00010\"0\"2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010#0#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u000e\u0010&\u001a\n \u001b*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001J)\u0010'\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010)0)2\u000e\u0010$\u001a\n \u001b*\u0004\u0018\u00010\t0\tH\u0096\u0001J)\u0010*\u001a\u00020\u000e2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010#0#2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0096\u0001J\t\u0010+\u001a\u00020\u000eH\u0096\u0001J\b\u0010,\u001a\u00020(H\u0016J\b\u0010-\u001a\u00020(H\u0016J\u0018\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020)2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0019\u00100\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\u0019\u00101\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001Ji\u00102\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u000103032\u000e\u0010$\u001a\n \u001b*\u0004\u0018\u00010\u00020\u00022\u000e\u0010%\u001a\n \u001b*\u0004\u0018\u000104042\u000e\u0010&\u001a\n \u001b*\u0004\u0018\u00010\u00020\u00022\u000e\u00105\u001a\n \u001b*\u0004\u0018\u00010\u00020\u00022\u000e\u00106\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\u0019\u00107\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\u0019\u00108\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\u0019\u00109\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\u0019\u0010:\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\u0019\u0010;\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J\u0019\u0010<\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001JI\u0010=\u001a\u00020(2\u000e\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u00020\u00022\u000e\u0010$\u001a\n \u001b*\u0004\u0018\u00010\u00120\u00122\u000e\u0010%\u001a\n \u001b*\u0004\u0018\u00010#0#2\u000e\u0010&\u001a\n \u001b*\u0004\u0018\u00010\u00120\u0012H\u0097\u0001J(\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u0012H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/template/VasProfileTemplateComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileComponent;", "Landroid/view/View;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateManager;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateUtils;", "Lcom/tencent/mobileqq/profilecard/template/IDiyMoreInfoManager;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "adHelper", "Lcom/tencent/mobileqq/profilecard/vas/component/accountinfo/ProfileAdWindowHelper;", "isCheckTianshuAd", "", "mVasProfileTemplateController", "Lcom/tencent/mobileqq/vas/profilecard/IProfileTemplateController;", "getComponentName", "", "getComponentType", "", "getDiyTemplateVersion", "", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/data/Card;", "getPhotoWallDiyView", "V", "kotlin.jvm.PlatformType", "p0", "(Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)Landroid/view/View;", "getQZoneDiyView", "T", "(Ljava/lang/String;)Landroid/view/View;", "getTemplateDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "p1", "p2", "p3", "initDiyTemplate", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "initTemplateConfig", "isDiy", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onStart", "preNotifyOnCardUpdate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "updateAccountInfoForDeepDiy", "updateBaseInfoForDeepDiy", "updateItemThemeForDIYTemplate", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "p4", "p5", "updateLevelForDeepDiy", "updateMetalForDeepDiy", "updatePhotoWallForDeepDiy", "updateQzoneForDeepDiy", "updateSignForDeepDiy", "updateTroopMemInfoForDeepDiy", "updateViewAttr", "updateViewAttrForTemplate", "view", "attr", "currentTemplate", "attrKey", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class VasProfileTemplateComponent extends AbsProfileComponent<View> implements ITemplateManager, ITemplateUtils, IDiyMoreInfoManager {

    @NotNull
    private static final String TAG = "VasProfileTemplateComponent";
    private final /* synthetic */ TemplateUtilsImpl $$delegate_0;
    private final /* synthetic */ DiyMoreInfoManagerImpl $$delegate_1;

    @NotNull
    private final ProfileAdWindowHelper adHelper;
    private boolean isCheckTianshuAd;

    @Nullable
    private IProfileTemplateController mVasProfileTemplateController;

    public VasProfileTemplateComponent(@Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.$$delegate_0 = new TemplateUtilsImpl();
        this.$$delegate_1 = new DiyMoreInfoManagerImpl();
        this.adHelper = new ProfileAdWindowHelper();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    @NotNull
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1034;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        r1 = r0.nextLong();
     */
    @Override // com.tencent.mobileqq.profilecard.template.ITemplateManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getDiyTemplateVersion(@NotNull Card card) {
        Intrinsics.checkNotNullParameter(card, "card");
        long j3 = 0;
        if (!ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId) || TextUtils.isEmpty(card.diyComplicatedInfo)) {
            return 0L;
        }
        JsonReader jsonReader = new JsonReader(new StringReader(card.diyComplicatedInfo));
        try {
            try {
                jsonReader.beginObject();
                while (true) {
                    if (!jsonReader.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual("v", jsonReader.nextName())) {
                        break;
                    }
                    jsonReader.skipValue();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(jsonReader, null);
            return j3;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(jsonReader, th5);
                throw th6;
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public <V extends View> V getPhotoWallDiyView(ProfileCardInfo p06) {
        return (V) this.$$delegate_1.getPhotoWallDiyView(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public <T extends View> T getQZoneDiyView(String p06) {
        return (T) this.$$delegate_1.getQZoneDiyView(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    public Drawable getTemplateDrawable(ProfileCardTemplate p06, boolean p16, boolean p26, String p36) {
        return this.$$delegate_0.getTemplateDrawable(p06, p16, p26, p36);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void initDiyTemplate(QBaseActivity p06, ProfileCardInfo p16) {
        this.$$delegate_1.initDiyTemplate(p06, p16);
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    public boolean initTemplateConfig(ProfileCardTemplate p06, long p16, long p26) {
        return this.$$delegate_0.initTemplateConfig(p06, p16, p26);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public boolean isDiy() {
        return this.$$delegate_1.isDiy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        super.onPause();
        this.adHelper.clearShowingState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStart() {
        super.onStart();
        this.adHelper.showingState();
        if (!this.isCheckTianshuAd) {
            ProfileAdWindowHelper profileAdWindowHelper = this.adHelper;
            DATA mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            profileAdWindowHelper.tianShuAdCheck((ProfileCardInfo) mData, this.mActivity);
            this.isCheckTianshuAd = true;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateManager
    public boolean preNotifyOnCardUpdate(@NotNull QBaseActivity activity, @NotNull ProfileCardInfo cardInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        if (this.mVasProfileTemplateController == null) {
            this.mVasProfileTemplateController = new VasProfileTemplateController(this.mActivity, new Function0<Unit>() { // from class: com.tencent.mobileqq.profilecard.vas.component.template.VasProfileTemplateComponent$preNotifyOnCardUpdate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IProfileActivityDelegate iProfileActivityDelegate;
                    IProfileActivityDelegate iProfileActivityDelegate2;
                    Object obj;
                    iProfileActivityDelegate = ((AbsProfileComponent) VasProfileTemplateComponent.this).mDelegate;
                    if (iProfileActivityDelegate != null) {
                        iProfileActivityDelegate2 = ((AbsProfileComponent) VasProfileTemplateComponent.this).mDelegate;
                        obj = ((AbsComponent) VasProfileTemplateComponent.this).mData;
                        iProfileActivityDelegate2.notifyCardUpdate(((ProfileCardInfo) obj).card);
                    }
                }
            });
        }
        IProfileTemplateController iProfileTemplateController = this.mVasProfileTemplateController;
        Intrinsics.checkNotNull(iProfileTemplateController);
        boolean onCardUpdate = iProfileTemplateController.onCardUpdate(this.mComponentCenter, cardInfo);
        initDiyTemplate(activity, cardInfo);
        return onCardUpdate;
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateAccountInfoForDeepDiy(View p06) {
        this.$$delegate_1.updateAccountInfoForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateBaseInfoForDeepDiy(View p06) {
        this.$$delegate_1.updateBaseInfoForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateItemThemeForDIYTemplate(TextView p06, View p16, ImageView p26, View p36, View p46, View p56) {
        this.$$delegate_1.updateItemThemeForDIYTemplate(p06, p16, p26, p36, p46, p56);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateLevelForDeepDiy(View p06) {
        this.$$delegate_1.updateLevelForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateMetalForDeepDiy(View p06) {
        this.$$delegate_1.updateMetalForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updatePhotoWallForDeepDiy(View p06) {
        this.$$delegate_1.updatePhotoWallForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateQzoneForDeepDiy(View p06) {
        this.$$delegate_1.updateQzoneForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateSignForDeepDiy(View p06) {
        this.$$delegate_1.updateSignForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateTroopMemInfoForDeepDiy(View p06) {
        this.$$delegate_1.updateTroopMemInfoForDeepDiy(p06);
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    @SuppressLint({"NewApi"})
    public void updateViewAttr(View p06, String p16, ProfileCardTemplate p26, String p36) {
        this.$$delegate_0.updateViewAttr(p06, p16, p26, p36);
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateManager
    public void updateViewAttrForTemplate(@NotNull View view, @NotNull String attr, @NotNull ProfileCardTemplate currentTemplate, @NotNull String attrKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attr, "attr");
        Intrinsics.checkNotNullParameter(currentTemplate, "currentTemplate");
        Intrinsics.checkNotNullParameter(attrKey, "attrKey");
        ProfileTemplateApi.getTemplateUtils(this.mComponentCenter).updateViewAttr(view, attr, currentTemplate, attrKey);
    }
}
