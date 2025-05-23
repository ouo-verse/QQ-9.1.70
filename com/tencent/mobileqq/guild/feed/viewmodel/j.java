package com.tencent.mobileqq.guild.feed.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rJ\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/viewmodel/j;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "mode", "", "M1", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "N1", "Q1", "P1", "R1", "O1", "Landroidx/lifecycle/MutableLiveData;", "L1", "", "getLogTag", "i", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "mFeedInitBean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "sortModeModel", BdhLogUtil.LogTag.Tag_Conn, "I", "curLatestSortType", "<init>", "()V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedBaseInitBean mFeedInitBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> sortModeModel = new MutableLiveData<>(3);

    /* renamed from: C, reason: from kotlin metadata */
    private int curLatestSortType = 1;

    private final void M1(int mode) {
        if (mode != 1 && mode != 2 && mode != 3) {
            this.sortModeModel.setValue(3);
            return;
        }
        if (mode != 2) {
            this.curLatestSortType = mode;
        }
        this.sortModeModel.setValue(Integer.valueOf(mode));
    }

    @NotNull
    public final MutableLiveData<Integer> L1() {
        return this.sortModeModel;
    }

    public final void N1(@NotNull GuildFeedBaseInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.mFeedInitBean = bean;
        M1(GuildInfoManager.q().x(this.mFeedInitBean));
    }

    public final void O1(int mode) {
        Integer value = this.sortModeModel.getValue();
        if (value != null && mode == value.intValue()) {
            return;
        }
        if (mode == 2) {
            Q1();
        } else {
            this.curLatestSortType = mode;
            this.sortModeModel.setValue(Integer.valueOf(mode));
        }
    }

    public final void P1() {
        Integer value = this.sortModeModel.getValue();
        if (value == null || value.intValue() != 2) {
            return;
        }
        this.sortModeModel.setValue(Integer.valueOf(this.curLatestSortType));
    }

    public final void Q1() {
        int intValue;
        Integer value = this.sortModeModel.getValue();
        if (value == null || value.intValue() != 2) {
            Integer value2 = this.sortModeModel.getValue();
            if (value2 == null) {
                intValue = 3;
            } else {
                intValue = value2.intValue();
            }
            this.curLatestSortType = intValue;
            this.sortModeModel.setValue(2);
        }
    }

    public final void R1() {
        Integer value = this.sortModeModel.getValue();
        if (value != null && value.intValue() == 2) {
            return;
        }
        Integer value2 = this.sortModeModel.getValue();
        int i3 = 3;
        if (value2 != null && value2.intValue() == 3) {
            i3 = 1;
        }
        this.curLatestSortType = i3;
        this.sortModeModel.setValue(Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "GuildFeedSortViewModel";
    }
}
