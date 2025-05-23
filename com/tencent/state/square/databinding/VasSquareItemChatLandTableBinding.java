package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.state.square.chatland.view.ChatLandTableView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemChatLandTableBinding implements ViewBinding {
    private final ChatLandTableView rootView;
    public final ChatLandTableView tableView;

    VasSquareItemChatLandTableBinding(ChatLandTableView chatLandTableView, ChatLandTableView chatLandTableView2) {
        this.rootView = chatLandTableView;
        this.tableView = chatLandTableView2;
    }

    public static VasSquareItemChatLandTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemChatLandTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5b, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ChatLandTableView getRoot() {
        return this.rootView;
    }

    public static VasSquareItemChatLandTableBinding bind(View view) {
        if (view != null) {
            ChatLandTableView chatLandTableView = (ChatLandTableView) view;
            return new VasSquareItemChatLandTableBinding(chatLandTableView, chatLandTableView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
