package com.tencent.mobileqq.search.fragment.searchentry;

import android.os.Bundle;
import android.text.Editable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface ISearchEntryFragment {
    public static final String KEY_FROM = "from";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_TABTYPE = "tabType";
    public static final String TAB_ID_CONTACT = "kSearchContactTab";
    public static final String TAB_ID_DYNAMIC = "kSearchDynamicTab";
    public static final String TAB_ID_MESSAGE = "kSearchMessageTab";
    public static final String TAB_ID_READINJOY_TAB = "kSearchReadInJoyTab";
    public static final String TAB_ID_WEB_TITLE = "kSearchWebTitle";
    public static final Map<Integer, Boolean> mIsModelsReported = new HashMap();

    void afterTextChanged(Editable editable);

    @NonNull
    QBaseFragment getFragment();

    @NonNull
    Bundle getInitData();

    void onSoftKeyboardClosed();

    void onSoftKeyboardOpened(int i3);

    void refresh();

    void refreshDataModels(List<SearchEntryDataModel> list);

    void setApp(@NonNull QQAppInterface qQAppInterface);

    void setInitData(@NonNull Bundle bundle);
}
