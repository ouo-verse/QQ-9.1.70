package nn2;

import com.tencent.mobileqq.app.QBaseFragment;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface b {
    long[] getCurrentPageMasks();

    int getCurrentPageType();

    QBaseFragment getCurrentSearchFragment();

    String getSearchKeyword();

    boolean isInitiativeSearch();

    boolean isInputPinyin();
}
