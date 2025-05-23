package com.tencent.mobileqq.wink.publish.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.publish.base.PublishSettingItem;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J&\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\fH\u0016J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\fJ\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00020+j\b\u0012\u0004\u0012\u00020\u0002`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.RD\u00103\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u0002 0*\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010+j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`,0+j\b\u0012\u0004\u0012\u00020\u0002`,0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00102R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010=R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\bE\u0010;\u001a\u0004\bF\u0010=R\u001d\u0010J\u001a\b\u0012\u0004\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bI\u0010=R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\bK\u0010;\u001a\u0004\bL\u0010=\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/publish/base/PublishSettingItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", NodeProps.VISIBLE, "", "E2", "flag", "Landroidx/lifecycle/MutableLiveData;", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "e2", "", "d2", "z2", "w2", ICustomDataEditor.STRING_PARAM_2, "C2", "q2", ICustomDataEditor.NUMBER_PARAM_2, "u2", "v2", "p2", "L2", "K2", "I2", "J2", "H2", "M2", Constants.MMCCID, "F2", "getLogTag", "S2", "Q2", "U2", "N2", "O2", "P2", "R2", "T2", "k2", "", "j2", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "i", "Ljava/util/HashSet;", "selectMutexItems", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "visibleItems", BdhLogUtil.LogTag.Tag_Conn, "labelAtFriendLink", "D", "ecSourceLocSchoolSelectMutex", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/mobileqq/wink/publish/viewmodel/q;", "E", "Landroidx/lifecycle/MediatorLiveData;", "l2", "()Landroidx/lifecycle/MediatorLiveData;", "schoolState", UserInfo.SEX_FEMALE, "g2", "ecState", "G", "i2", "locationState", "H", "m2", "shareSourceState", "I", SemanticAttributes.DbSystemValues.H2, "labelListState", "J", "f2", "atFriendState", "<init>", "()V", "K", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PartsStateViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> labelAtFriendLink;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PublishSettingItem> ecSourceLocSchoolSelectMutex;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PublishSettingItemState> schoolState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PublishSettingItemState> ecState;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PublishSettingItemState> locationState;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PublishSettingItemState> shareSourceState;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PublishSettingItemState> labelListState;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PublishSettingItemState> atFriendState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<PublishSettingItem> selectMutexItems;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<HashSet<PublishSettingItem>> visibleItems;

    public PartsStateViewModel() {
        HashSet<PublishSettingItem> hashSetOf;
        HashSet hashSetOf2;
        PublishSettingItem publishSettingItem = PublishSettingItem.LOCATION;
        hashSetOf = SetsKt__SetsKt.hashSetOf(PublishSettingItem.TROOP, PublishSettingItem.PROMOTION, PublishSettingItem.SCHOOL, publishSettingItem, PublishSettingItem.SHARE_SOURCE);
        this.selectMutexItems = hashSetOf;
        hashSetOf2 = SetsKt__SetsKt.hashSetOf(publishSettingItem);
        this.visibleItems = new MutableLiveData<>(hashSetOf2);
        this.labelAtFriendLink = new MutableLiveData<>();
        this.ecSourceLocSchoolSelectMutex = new MutableLiveData<>();
        this.schoolState = new MediatorLiveData<>();
        this.ecState = new MediatorLiveData<>();
        this.locationState = new MediatorLiveData<>();
        this.shareSourceState = new MediatorLiveData<>();
        this.labelListState = new MediatorLiveData<>();
        this.atFriendState = new MediatorLiveData<>();
        z2();
        w2();
        s2();
        C2();
        u2();
        v2();
        n2();
        q2();
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void C2() {
        this.shareSourceState.setValue(new PublishSettingItemState(true, true, true));
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.shareSourceState;
        MutableLiveData<PublishSettingItem> mutableLiveData = this.ecSourceLocSchoolSelectMutex;
        final Function1<PublishSettingItem, Unit> function1 = new Function1<PublishSettingItem, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initShareSourceState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItem publishSettingItem) {
                invoke2(publishSettingItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItem publishSettingItem) {
                PartsStateViewModel.this.M2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.D2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void E2(PublishSettingItem item, boolean visible) {
        Boolean bool;
        HashSet<PublishSettingItem> value = this.visibleItems.getValue();
        HashSet<PublishSettingItem> hashSet = null;
        if (value != null) {
            bool = Boolean.valueOf(value.contains(item));
        } else {
            bool = null;
        }
        if (visible && Intrinsics.areEqual(bool, Boolean.FALSE)) {
            MutableLiveData<HashSet<PublishSettingItem>> mutableLiveData = this.visibleItems;
            HashSet<PublishSettingItem> value2 = mutableLiveData.getValue();
            if (value2 != null) {
                value2.add(item);
                hashSet = value2;
            }
            mutableLiveData.postValue(hashSet);
            return;
        }
        if (!visible && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            MutableLiveData<HashSet<PublishSettingItem>> mutableLiveData2 = this.visibleItems;
            HashSet<PublishSettingItem> value3 = mutableLiveData2.getValue();
            if (value3 != null) {
                value3.remove(item);
                hashSet = value3;
            }
            mutableLiveData2.postValue(hashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2() {
        boolean areEqual = Intrinsics.areEqual("AT_FRIEND", this.labelAtFriendLink.getValue());
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.atFriendState;
        PublishSettingItemState value = mediatorLiveData.getValue();
        Intrinsics.checkNotNull(value);
        mediatorLiveData.setValue(PublishSettingItemState.b(value, areEqual, false, false, 6, null));
        QLog.d("PartsStateViewModel", 1, "[preferAtFriendVisible] isVisible:" + areEqual);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2() {
        boolean areEqual = Intrinsics.areEqual("LABEL", this.labelAtFriendLink.getValue());
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.labelListState;
        PublishSettingItemState value = mediatorLiveData.getValue();
        Intrinsics.checkNotNull(value);
        mediatorLiveData.setValue(PublishSettingItemState.b(value, areEqual, false, false, 6, null));
        QLog.d("PartsStateViewModel", 1, "[preferLabelListVisible] isVisible:" + areEqual);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H2() {
        boolean z16;
        boolean z17 = false;
        if (PublishSettingItem.LOCATION == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || PublishSettingItem.NULL == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z17 = true;
        }
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.locationState;
        PublishSettingItemState value = mediatorLiveData.getValue();
        Intrinsics.checkNotNull(value);
        mediatorLiveData.setValue(PublishSettingItemState.b(value, false, z17, z16, 1, null));
        QLog.d("PartsStateViewModel", 1, "[preLocationSelectable] selectable:" + z17 + ", isSelected:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I2() {
        boolean z16;
        boolean z17 = false;
        if (PublishSettingItem.PROMOTION == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || PublishSettingItem.NULL == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z17 = true;
        }
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.ecState;
        PublishSettingItemState value = mediatorLiveData.getValue();
        Intrinsics.checkNotNull(value);
        mediatorLiveData.setValue(PublishSettingItemState.b(value, false, z17, z16, 1, null));
        QLog.d("PartsStateViewModel", 1, "[prePromotionSelectable] selectable:" + z17 + ", isSelected:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J2() {
        boolean z16;
        PublishSettingItemState publishSettingItemState;
        HashSet<PublishSettingItem> value = this.visibleItems.getValue();
        if (value != null && value.contains(PublishSettingItem.PROMOTION)) {
            z16 = true;
        } else {
            z16 = false;
        }
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.ecState;
        PublishSettingItemState value2 = mediatorLiveData.getValue();
        if (value2 != null) {
            Intrinsics.checkNotNullExpressionValue(value2, "value");
            publishSettingItemState = PublishSettingItemState.b(value2, z16, false, false, 6, null);
        } else {
            publishSettingItemState = null;
        }
        mediatorLiveData.setValue(publishSettingItemState);
        QLog.d("PartsStateViewModel", 1, "[preferPromotionVisible] state:" + mediatorLiveData.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2() {
        boolean z16;
        PublishSettingItemState publishSettingItemState;
        boolean z17 = false;
        if (PublishSettingItem.SCHOOL == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || PublishSettingItem.NULL == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z17 = true;
        }
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.schoolState;
        PublishSettingItemState value = mediatorLiveData.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "value");
            publishSettingItemState = PublishSettingItemState.b(value, false, z17, z16, 1, null);
        } else {
            publishSettingItemState = null;
        }
        mediatorLiveData.setValue(publishSettingItemState);
        QLog.d("PartsStateViewModel", 1, "[preferSchoolSelectable] selectable:" + z17 + ", isSelected:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L2() {
        boolean z16;
        boolean z17;
        boolean z18;
        PublishSettingItemState value;
        PublishSettingItemState publishSettingItemState;
        boolean z19;
        HashSet<PublishSettingItem> value2 = this.visibleItems.getValue();
        boolean z26 = false;
        if (value2 != null && !value2.contains(PublishSettingItem.PROMOTION)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            HashSet<PublishSettingItem> value3 = this.visibleItems.getValue();
            if (value3 != null && value3.contains(PublishSettingItem.SCHOOL)) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                z17 = true;
                if (PublishSettingItem.SCHOOL != this.ecSourceLocSchoolSelectMutex.getValue()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18 || PublishSettingItem.NULL == this.ecSourceLocSchoolSelectMutex.getValue()) {
                    z26 = true;
                }
                MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.schoolState;
                value = mediatorLiveData.getValue();
                if (value == null) {
                    publishSettingItemState = value.a(z17, z26, z18);
                } else {
                    publishSettingItemState = null;
                }
                mediatorLiveData.setValue(publishSettingItemState);
                QLog.d("PartsStateViewModel", 1, "[preferSchoolVisible] visible:" + mediatorLiveData.getValue());
            }
        }
        z17 = false;
        if (PublishSettingItem.SCHOOL != this.ecSourceLocSchoolSelectMutex.getValue()) {
        }
        if (!z18) {
        }
        z26 = true;
        MediatorLiveData<PublishSettingItemState> mediatorLiveData2 = this.schoolState;
        value = mediatorLiveData2.getValue();
        if (value == null) {
        }
        mediatorLiveData2.setValue(publishSettingItemState);
        QLog.d("PartsStateViewModel", 1, "[preferSchoolVisible] visible:" + mediatorLiveData2.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M2() {
        boolean z16;
        boolean z17 = false;
        if (PublishSettingItem.SHARE_SOURCE == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || PublishSettingItem.NULL == this.ecSourceLocSchoolSelectMutex.getValue()) {
            z17 = true;
        }
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.shareSourceState;
        PublishSettingItemState value = mediatorLiveData.getValue();
        Intrinsics.checkNotNull(value);
        mediatorLiveData.setValue(PublishSettingItemState.b(value, false, z17, z16, 1, null));
        QLog.d("PartsStateViewModel", 1, "[preferBssSelectable] selectable:" + z17 + ", isSelected:" + z16);
    }

    private final void d2(boolean flag, PublishSettingItem item, MutableLiveData<String> link) {
        if (flag) {
            link.setValue(item.name());
        } else if (Intrinsics.areEqual(item.name(), this.labelAtFriendLink.getValue())) {
            link.setValue("NULL");
        }
    }

    private final void e2(boolean flag, PublishSettingItem item, MutableLiveData<PublishSettingItem> link) {
        if (flag && item == link.getValue()) {
            return;
        }
        if (flag) {
            link.setValue(item);
        } else if (item == this.ecSourceLocSchoolSelectMutex.getValue()) {
            link.setValue(PublishSettingItem.NULL);
        }
    }

    private final void n2() {
        this.atFriendState.setValue(new PublishSettingItemState(false, true, true));
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.atFriendState;
        MutableLiveData<String> mutableLiveData = this.labelAtFriendLink;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initAtFriendState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                PartsStateViewModel.this.F2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.o2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void p2() {
        this.labelAtFriendLink.setValue("LABEL");
    }

    private final void q2() {
        this.labelListState.setValue(new PublishSettingItemState(true, true, true));
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.labelListState;
        MutableLiveData<String> mutableLiveData = this.labelAtFriendLink;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initLabelListState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                PartsStateViewModel.this.G2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.r2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void s2() {
        this.locationState.setValue(new PublishSettingItemState(true, true, false));
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.locationState;
        MutableLiveData<PublishSettingItem> mutableLiveData = this.ecSourceLocSchoolSelectMutex;
        final Function1<PublishSettingItem, Unit> function1 = new Function1<PublishSettingItem, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initLocationState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItem publishSettingItem) {
                invoke2(publishSettingItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItem publishSettingItem) {
                PartsStateViewModel.this.H2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.t2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void u2() {
        this.ecSourceLocSchoolSelectMutex.setValue(PublishSettingItem.NULL);
    }

    private final void w2() {
        this.ecState.setValue(new PublishSettingItemState(false, true, false));
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.ecState;
        MutableLiveData<HashSet<PublishSettingItem>> mutableLiveData = this.visibleItems;
        final Function1<HashSet<PublishSettingItem>, Unit> function1 = new Function1<HashSet<PublishSettingItem>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initPromotionState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashSet<PublishSettingItem> hashSet) {
                invoke2(hashSet);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashSet<PublishSettingItem> hashSet) {
                PartsStateViewModel.this.J2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.x2(Function1.this, obj);
            }
        });
        MediatorLiveData<PublishSettingItemState> mediatorLiveData2 = this.ecState;
        MutableLiveData<PublishSettingItem> mutableLiveData2 = this.ecSourceLocSchoolSelectMutex;
        final Function1<PublishSettingItem, Unit> function12 = new Function1<PublishSettingItem, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initPromotionState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItem publishSettingItem) {
                invoke2(publishSettingItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItem publishSettingItem) {
                PartsStateViewModel.this.I2();
            }
        };
        mediatorLiveData2.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.y2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void z2() {
        this.schoolState.setValue(new PublishSettingItemState(true, true, false));
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this.schoolState;
        MutableLiveData<HashSet<PublishSettingItem>> mutableLiveData = this.visibleItems;
        final Function1<HashSet<PublishSettingItem>, Unit> function1 = new Function1<HashSet<PublishSettingItem>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initSchoolState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashSet<PublishSettingItem> hashSet) {
                invoke2(hashSet);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashSet<PublishSettingItem> hashSet) {
                PartsStateViewModel.this.L2();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.A2(Function1.this, obj);
            }
        });
        MediatorLiveData<PublishSettingItemState> mediatorLiveData2 = this.schoolState;
        MutableLiveData<PublishSettingItem> mutableLiveData2 = this.ecSourceLocSchoolSelectMutex;
        final Function1<PublishSettingItem, Unit> function12 = new Function1<PublishSettingItem, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$initSchoolState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItem publishSettingItem) {
                invoke2(publishSettingItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItem publishSettingItem) {
                PartsStateViewModel.this.K2();
            }
        };
        mediatorLiveData2.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartsStateViewModel.B2(Function1.this, obj);
            }
        });
    }

    public final void N2(boolean visible) {
        PublishSettingItem publishSettingItem = PublishSettingItem.AT_FRIEND;
        E2(publishSettingItem, visible);
        d2(visible, publishSettingItem, this.labelAtFriendLink);
    }

    public final void O2(boolean flag) {
        e2(flag, PublishSettingItem.LOCATION, this.ecSourceLocSchoolSelectMutex);
    }

    public final void P2(boolean flag) {
        e2(flag, PublishSettingItem.PROMOTION, this.ecSourceLocSchoolSelectMutex);
    }

    public final void Q2(boolean visible) {
        E2(PublishSettingItem.PROMOTION, visible);
    }

    public final void R2(boolean flag) {
        e2(flag, PublishSettingItem.SCHOOL, this.ecSourceLocSchoolSelectMutex);
    }

    public final void S2(boolean visible) {
        E2(PublishSettingItem.SCHOOL, visible);
    }

    public final void T2(boolean flag) {
        e2(flag, PublishSettingItem.SHARE_SOURCE, this.ecSourceLocSchoolSelectMutex);
    }

    public final void U2() {
        E2(PublishSettingItem.TROOP, true);
    }

    @NotNull
    public final MediatorLiveData<PublishSettingItemState> f2() {
        return this.atFriendState;
    }

    @NotNull
    public final MediatorLiveData<PublishSettingItemState> g2() {
        return this.ecState;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "PartsStateViewModel";
    }

    @NotNull
    public final MediatorLiveData<PublishSettingItemState> h2() {
        return this.labelListState;
    }

    @NotNull
    public final MediatorLiveData<PublishSettingItemState> i2() {
        return this.locationState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.intersect(r0, r2.selectMutexItems);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<PublishSettingItem> j2() {
        List<PublishSettingItem> emptyList;
        Set intersect;
        List<PublishSettingItem> list;
        HashSet<PublishSettingItem> value = this.visibleItems.getValue();
        if (value == null || intersect == null || list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    @NotNull
    public final String k2() {
        String str;
        String joinToString$default;
        if (j2().size() > 2) {
            str = "\u3001";
        } else {
            str = "\u548c";
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(j2(), str, null, null, 0, null, new Function1<PublishSettingItem, CharSequence>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel$getMutexItemsToastText$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull PublishSettingItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getText();
            }
        }, 30, null);
        return "\u65e0\u6cd5\u540c\u65f6\u6dfb\u52a0" + joinToString$default;
    }

    @NotNull
    public final MediatorLiveData<PublishSettingItemState> l2() {
        return this.schoolState;
    }

    @NotNull
    public final MediatorLiveData<PublishSettingItemState> m2() {
        return this.shareSourceState;
    }

    private final void v2() {
    }
}
