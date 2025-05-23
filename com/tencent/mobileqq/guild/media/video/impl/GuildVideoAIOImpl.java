package com.tencent.mobileqq.guild.media.video.impl;

import com.tencent.mobileqq.guild.media.video.IGuildVideoAIO;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildVideoAIOImpl implements IGuildVideoAIO {
    @Override // com.tencent.mobileqq.guild.media.video.IGuildVideoAIO
    public int[] getMixThumbSize(int i3, int i16, int i17) {
        float contentview_max_width_size = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getCONTENTVIEW_MAX_WIDTH_SIZE() + 0.5f;
        if (i3 > i16) {
            contentview_max_width_size = (((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getCONTENTVIEW_MAX_WIDTH_SIZE() + 0.5f) - (i17 * 2);
        }
        if (i3 < i16) {
            contentview_max_width_size *= 0.7f;
        }
        return new int[]{(int) contentview_max_width_size, (int) ((i16 * contentview_max_width_size) / i3)};
    }

    @Override // com.tencent.mobileqq.guild.media.video.IGuildVideoAIO
    public int[] getThumbSize(int i3, int i16) {
        float contentview_max_width_size = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getCONTENTVIEW_MAX_WIDTH_SIZE() + 0.5f;
        if (i3 < i16) {
            contentview_max_width_size *= 0.7f;
        }
        return new int[]{(int) contentview_max_width_size, (int) ((i16 * contentview_max_width_size) / i3)};
    }
}
