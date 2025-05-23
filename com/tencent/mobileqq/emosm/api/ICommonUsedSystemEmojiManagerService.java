package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.pb.emosm.EmosmPb$SmallYellowItem;
import java.io.File;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface ICommonUsedSystemEmojiManagerService extends IRuntimeService {
    void copySystemEmojiFileToFileV2(File file, File file2);

    List<EmosmPb$SmallYellowItem> getCacheInfo();

    List<EmosmPb$SmallYellowItem> getCommonUsedSystemEmojiInfo();

    List<EmosmPb$SmallYellowItem> getLocalSystemEmojiInfoFromFile();

    List<EmosmPb$SmallYellowItem> getPaddedData(List<EmosmPb$SmallYellowItem> list);

    List<EmosmPb$SmallYellowItem> mergeAndSortSystemEmojiInfo(List<EmosmPb$SmallYellowItem> list, List<EmosmPb$SmallYellowItem> list2);

    List<EmosmPb$SmallYellowItem> mergeList(List<EmosmPb$SmallYellowItem> list);

    void saveSystemEmojiInfoToCahce(EmosmPb$SmallYellowItem emosmPb$SmallYellowItem);

    void saveSystemEmojiInfoToFile();

    void updateItemInfo(List<EmosmPb$SmallYellowItem> list);
}
