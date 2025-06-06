package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes2.dex */
public final class FilteringHlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private final List<String> filter;
    private final HlsPlaylistParser hlsPlaylistParser = new HlsPlaylistParser();

    public FilteringHlsPlaylistParser(List<String> list) {
        this.filter = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        HlsPlaylist parse = this.hlsPlaylistParser.parse(uri, inputStream);
        return parse instanceof HlsMasterPlaylist ? ((HlsMasterPlaylist) parse).copy(this.filter) : parse;
    }
}
